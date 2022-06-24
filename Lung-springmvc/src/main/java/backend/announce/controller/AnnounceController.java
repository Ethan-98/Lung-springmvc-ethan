package backend.announce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import backend.announce.model.AnnounceBean;
import backend.announce.service.AnnounceService;

@Controller
@RequestMapping("/Backendannounce")
public class AnnounceController {
	
	@Autowired
	private AnnounceService announceService;
	
	@GetMapping("/announcelist")
	public String listAnnounce(Model model) {
		List<AnnounceBean> announceBeans = announceService.getAnnounce();
		model.addAttribute("announces",announceBeans);
		return "Backendannounce/announce";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model model) {
		AnnounceBean announceBean = new AnnounceBean();
		model.addAttribute("announce", announceBean);
		return "Backendannounce/announceNewForm";
	}

	@PostMapping("/saveAnnounce")
	public String saveAnnounce(@ModelAttribute("announce") AnnounceBean announceBean) {
		announceService.saveAnnounce(announceBean);
		return "redirect:/Backendannounce/announcelist";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("announceID") Integer anNO, Model model) {
		AnnounceBean announceBean = announceService.getAnnounceBean(anNO);
		model.addAttribute("announce", announceBean);
		return "Backendannounce/announceEditForm";
	}
	
	@GetMapping("/delete")
	public String deleteAnnounce(@RequestParam("announceID") Integer anNO) {
		announceService.deleteAnnounce(anNO);
		return "redirect:/Backendannounce/announcelist";
	}
}
