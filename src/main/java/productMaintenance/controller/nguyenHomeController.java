package productMaintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import productMaintenance.model.Product;
import productMaintenance.repository.ProductRepository;

@Controller
@RequestMapping("/")
public class nguyenHomeController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping
	public String homeView() {
		return "index";
	}
	
	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		
		
		return "add";
	}
	
	@PostMapping("/add")
	public String addProductPost(Product product,Errors errors ,Model model) {
		if(errors.hasErrors()) {
			model.addAttribute("error", "something wrong.");
			model.addAttribute("product", product);
			return "add";
		}
		
		productRepo.save(product);
		
		return "redirect:display";
	}
}
