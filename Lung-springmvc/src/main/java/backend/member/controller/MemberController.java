package backend.member.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import backend.member.model.MemberBean;
import backend.member.service.MemberService;


@Controller
@RequestMapping("/Backendmember")
public class MemberController {
	

	@Autowired
	private MemberService memberService;
	@Autowired
	ServletContext ctx;

	String imageLocation = "resources\\images\\memberHeadshot";
	
	@Autowired
	public MemberController(MemberService memberService,ServletContext ctx) {
		this.memberService = memberService;
		this.ctx = ctx;
	}

	
	@GetMapping("/memberlist")  // 查詢(用GET)
	public String listMembers(Model model) {
		List<MemberBean> memberBeans = memberService.findAll();
		model.addAttribute("members", memberBeans);
		return "Backendmember/member";
	}

	@GetMapping("/showForm")  // 顯示新增表單
	public String showFormForAdd(Model model) {
		MemberBean memberBean = new MemberBean();  //?
		model.addAttribute("member", memberBean);  //?
		return "Backendmember/memberNewForm";
	}

	@PostMapping(value ="/saveMember")  // 新增或更新
	public String saveMember(@ModelAttribute("member") MemberBean memberBean) {
		System.out.println("getImage: " + (memberBean.getImage()==null));
		Boolean isInsert = (memberBean.getMi_no() ==null); // 判斷是否為insert
		
		MemberBean memberBean1 = saveHeadshotInDB(memberBean,isInsert);  // 取得MultipartFile，把圖片以BLOB型態塞進DB //setImage( )
		saveHeadshotInLocal(memberBean1,isInsert);  // 把圖片塞到本機 && setLocalfileName()
		memberService.saveMember(memberBean1);  // 塞進DB後才產生mi_no
		
		return "redirect:/Backendmember/memberlist";  // 重導到查詢頁面 //redirect不帶資料
	}

	@GetMapping("/updateForm")  // 顯示更新頁面
	public String showFormForUpdate(@RequestParam("memberID") Integer mi_no, Model model) {
		MemberBean memberBean = memberService.findById(mi_no);
		model.addAttribute("member", memberBean);
		return "Backendmember/memberEditForm";
	}
	
	@GetMapping("/delete")  //刪除
	public String deleteMember(@RequestParam("memberID") Integer mi_no) {
		memberService.deleteMember(mi_no);
		return "redirect:/Backendmember/memberlist";
	}
	
	/*
	private void outputJson(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		OutputJson outputJson = new OutputJson();
		outputJson.outputJson("D:\\outputMembers.json");
		RequestDispatcher dispatcher = request.getRequestDispatcher("memberOutput.jsp"); // 重導到查詢頁面
		dispatcher.forward(request, response);
	}
	*/
	
	
	
	
	
	
	
	
	
	// 讓「查詢頁面」可以取得db中的BLOB圖片欄
	@GetMapping("/picture/{mi_no}")
	public ResponseEntity<byte[]> getPicture(@PathVariable("mi_no") Integer mi_no) {
		byte[] body = null;
		ResponseEntity<byte[]> responseEntity = null;
		MediaType mediaType = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		MemberBean member = memberService.findById(mi_no);

		// 沒有會員資料
		if(member == null) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}else {
		// 有會員資料
			String localfilename = member.getLocalfileName();
			// 有local檔名 -> 因為csv直接匯入 || 有新增照片
			if(localfilename != null) {
				// 設定ResponseHeaders
				/* 透過檔名 setContentType(MediaType) */
				if (localfilename.toLowerCase().endsWith("jfif")) {
					mediaType = MediaType.valueOf(ctx.getMimeType("dummy.jpeg"));
				} else {
					mediaType = MediaType.valueOf(ctx.getMimeType(localfilename));
					headers.setContentType(mediaType);
				}
				// 設定ResponseBody
				body = fileToByteArray("/resources/images/memberHeadshot/" + localfilename);	
			}else {
			//沒有local檔名 -> 新增不傳圖片 -> 所以要顯示預設圖片
				body = fileToByteArray("/resources/images/memberHeadshot/defaultHeadshot.jpg");  //如果圖片為空，就上傳預設圖片
			}
			responseEntity = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
			return responseEntity;
		}	
	}
		


	private byte[] fileToByteArray(String path) {
		byte[] result = null;
		try (InputStream is = ctx.getResourceAsStream(path);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public byte[] blobToByteArray(Blob blob) {
		byte[] result = null;
		try (InputStream is = blob.getBinaryStream(); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	
	
	// MultipartFile 轉 BLOB型態 ，塞進DB
	public MemberBean saveHeadshotInDB(MemberBean memberBean, Boolean isInsert) {
		MultipartFile picture = memberBean.getProductImage(); //取得MultipartFile檔案
		// setImage (建立Blob物件，交由 Hibernate 寫入資料庫)
		if (picture != null && !picture.isEmpty()) {
			// 如果有上傳照片
			try {
				byte[] b = picture.getBytes();
				Blob blob = new SerialBlob(b);
				memberBean.setImage(blob);   //塞BLOB
				return memberBean;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}else { 
			// 如果沒有上傳照片
			if( !isInsert ) { // 是update時
				try {
					memberBean.setImage(memberService.findById(memberBean.getMi_no()).getImage());  // 找DB中的舊照片
					System.out.println("setImaget 成功");
					return memberBean;
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("修改時 檔案上傳發生異常: " + e.getMessage());
				}	
			} // 不是update時不用setImage
			return memberBean;
		}
	}
	
	
	// 把圖片塞到本機(放在此專案下)
	public void saveHeadshotInLocal(MemberBean memberBean, Boolean isInsert) {
		String contextPath = ctx.getRealPath("");
		String savePath = contextPath + imageLocation /* + File.separator*/;
		System.out.println("savePath: " + savePath);
		// 建立資料夾
		File fileSaveDir = new File(savePath); //Server端的站存資料夾 -> D:\1_iSpan\_TeamWork\teamWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Lung-springmvc\resource\images\localImage
		if (!fileSaveDir.exists()) {fileSaveDir.mkdir(); /*如果沒有這個資料夾，就建立資料夾*/  }
		// 把圖片存到本機資料夾
		String filename = null;
		MultipartFile picture = memberBean.getProductImage();
		// 如果有取得MultipartFile(有上傳照片)
		if (picture != null && !picture.isEmpty()) {
			// setLocalfileName( ) && 存圖片到本機
			// 不管是insert 或 update都要執行
			try {
				filename =  System.currentTimeMillis() + "_" + picture.getOriginalFilename();  //串接檔名 -> 毫秒_原始檔名
				File saveFile = new File(fileSaveDir, filename);
				picture.transferTo(saveFile);  // 存到硬碟
				memberBean.setLocalfileName(filename);
				System.out.println("LocalfileName:" + filename);
				System.out.println("照片存到本機專案下 -> 成功");		
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("修改時 照片存到本機有問題");
			}
			// 是update時
			if( !isInsert ) {
				try {
					// 刪除本機舊照片
					deleteHeadshotInLocal(memberBean);
				} catch (Exception e) {
					System.out.println("修改時 刪除本機照片有問題");
				}
			}		
		}else {
		// 如果沒有取得MultipartFile(沒有上傳照片)
			if( !isInsert ) {
				// 是update時
				try {
					memberBean.setLocalfileName(memberService.findById(memberBean.getMi_no()).getLocalfileName());
					System.out.println("setLocalfileName 成功");
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("修改時 setLocalfileName()發生異常: " + e.getMessage());
				}
			}else {
				// 不是update時不用setLocalfileName
				System.out.println("==========離開 saveHeadshotInLocal()==========");
			}
		}
	 }


	public void deleteHeadshotInLocal(MemberBean member) {
		String contextPath = ctx.getRealPath("");
		String filePath = contextPath + imageLocation + File.separator;
		System.out.println("filePath: " + filePath);
		
		String oldFilenameString = memberService.findById(member.getMi_no()).getLocalfileName();  //找到本地的舊檔名
		System.out.println("oldFilenameString:" + oldFilenameString);
		try {
			File file = new File(filePath + oldFilenameString);
			file.delete();
			System.out.println("本地圖片檔已被刪除");
			System.out.println("刪除的檔名為: " + oldFilenameString);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("刪除檔案有錯");
		}
	}
	

	
	
	
	
	
	
	
	
	
}
