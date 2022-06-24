package backend.animal.bean;
import javax.persistence.Column;
import javax.persistence.Entity; //Entity相當於自動配對bean資料庫的連接方式
import javax.persistence.GeneratedValue;//自動生成方式 可手動
import javax.persistence.GenerationType;//格式
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //實體類
@Table(name="AbDog") //資料表

public class AbDogBean {
	@Id //主KEY     自動生成                     每次+1
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//有小老鼠 為資料表跟baen兩個名稱不一樣
	private int id; //以後boot用long
	private String abid;
	private String abname;
	private String abphone;
	private String abemail;
	private String abdogname;
	private String abimage;
	private String abaddress;
	private String abtype;
	private int abage;	
	private String abdate;
	private String abremark;
	
	

	public AbDogBean(String abid, String abname, String abphone, String abemail, String abdogname, String abimage,
			String abaddress, String abtype, int abage, String abdate, String abremark) {
		super();
		this.abid = abid;
		this.abname = abname;
		this.abphone = abphone;
		this.abemail = abemail;
		this.abdogname = abdogname;
		this.abimage = abimage;
		this.abaddress = abaddress;
		this.abtype = abtype;
		this.abage = abage;
		this.abdate = abdate;
		this.abremark = abremark;
	}
	public AbDogBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AbDogBean(int id, String abid, String abname, String abphone, String abemail, String abdogname,
			String abimage, String abaddress, String abtype, int abage, String abdate, String abremark) {
		super();
		this.id = id;
		this.abid = abid;
		this.abname = abname;
		this.abphone = abphone;
		this.abemail = abemail;
		this.abdogname = abdogname;
		this.abimage = abimage;
		this.abaddress = abaddress;
		this.abtype = abtype;
		this.abage = abage;
		this.abdate = abdate;
		this.abremark = abremark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAbid() {
		return abid;
	}
	public void setAbid(String abid) {
		this.abid = abid;
	}
	public String getAbname() {
		return abname;
	}
	public void setAbname(String abname) {
		this.abname = abname;
	}
	public String getAbphone() {
		return abphone;
	}
	public void setAbphone(String abphone) {
		this.abphone = abphone;
	}
	public String getAbemail() {
		return abemail;
	}
	public void setAbemail(String abemail) {
		this.abemail = abemail;
	}
	public String getAbdogname() {
		return abdogname;
	}
	public void setAbdogname(String abdogname) {
		this.abdogname = abdogname;
	}
	public String getAbimage() {
		return abimage;
	}
	public void setAbimage(String abimage) {
		this.abimage = abimage;
	}
	public String getAbaddress() {
		return abaddress;
	}
	public void setAbaddress(String abaddress) {
		this.abaddress = abaddress;
	}
	public String getAbtype() {
		return abtype;
	}
	public void setAbtype(String abtype) {
		this.abtype = abtype;
	}
	public int getAbage() {
		return abage;
	}
	public void setAbage(int abage) {
		this.abage = abage;
	}
	public String getAbdate() {
		return abdate;
	}
	public void setAbdate(String abdate) {
		this.abdate = abdate;
	}
	public String getAbremark() {
		return abremark;
	}
	public void setAbremark(String abremark) {
		this.abremark = abremark;
	}}
	

