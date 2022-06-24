package backend.product.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import backend.product.model.ProductBean;
import backend.product.service.ProductService;

@Controller
@RequestMapping("/Backendproduct")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/productlist")
	public String listProduct(Model model) {
		List<ProductBean> productBean = productService.getProduct();
		model.addAttribute("product", productBean);
		return "Backendproduct/product";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model) {
		ProductBean productBean = new ProductBean();
		model.addAttribute("product", productBean);
		return "Backendproduct/productNewForm";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") ProductBean productBean) {
		productService.saveProduct(productBean);
		return "redirect:/Backendproduct/productlist";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("productID") Integer pd_id, Model model) {
		ProductBean productBean = productService.getProductBean(pd_id);
		model.addAttribute("product", productBean);
		return "Backendproduct/productEditForm";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productID") Integer pd_id) {
		productService.deleteProduct(pd_id);
		return "redirect:/Backendproduct/productlist";
	}
}
