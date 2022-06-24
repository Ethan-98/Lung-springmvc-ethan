package backend.animal.controller;
import java.util.List;

import javax.persistence.Query;//持久層.查詢
import javax.persistence.criteria.CriteriaBuilder;//標準建構查詢方式
import javax.persistence.criteria.CriteriaQuery;//查詢語句
import javax.persistence.criteria.Root;//選擇欄位

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;//自動配置
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;//類型 資料庫 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import backend.animal.bean.*;

import backend.animal.bean.AbDogBean;
import backend.animal.service.AbDogService;

@Controller
//@RequestMapping("/customer")  //生產
//@RequestMapping(value = "/abdog",produces = {"text/plain;charset=utf-8\",\"text/html;charset=utf-8"})
@RequestMapping(value = "/BackendAnimal",produces = {"text/plain;charset=utf-8\",\"text/html;charset=utf-8"})
public class AbDogController {
    @Autowired
    private AbDogService abdogservice;

    @GetMapping("/animallist")
    public String listCustomers(Model model) {
        List < AbDogBean > abdogbean = abdogservice.getAbDog();
        model.addAttribute("abdogbean", abdogbean);
        return "BackendAnimal/abdoglist";

    
}
    @GetMapping("/showForm")//虛擬網址新增頁面
    public String ShowFormForAdd(Model model) {
        AbDogBean abdogbean = new AbDogBean();
        model.addAttribute("abdogbean", abdogbean);
        return "BackendAnimal/abdogNewForm";
    }
    
    @PostMapping("/saveAbDog")            //前端傳來的集合 配對屬性
    public String SaveAbDog(@ModelAttribute("abdogbean") AbDogBean abdogbean) {
    	abdogservice.saveAbDog(abdogbean);
        return "redirect:/BackendAnimal/animallist";
    }

    @GetMapping("/updateForm")
    public String ShowFormForUpdate(@RequestParam("Id") int Id,
        Model model) {
        AbDogBean abdogbean = abdogservice.getAbDogById(Id);
        model.addAttribute("abdogbean", abdogbean);
        return "BackendAnimal/abdogEditForm";
    }
    @GetMapping("/delete")
    public String deleteAbDog(@RequestParam("Id") int Id) {
        abdogservice.deleteAbDog(Id);
        return "redirect:/BackendAnimal/animallist";
    }
}