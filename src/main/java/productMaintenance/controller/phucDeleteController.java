package productMaintenance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import productMaintenance.model.Product;
import productMaintenance.repository.ProductRepository;

@Controller
@Slf4j
@RequestMapping("/delete")
public class phucDeleteController {
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping
	public String deleteView(@RequestParam(name="code") String code, Model model) {
		Product product = productRepo.findById(code).get();
		log.info(product.toString());
		model.addAttribute("product", product);
		return "delete";
	}
	
	@PostMapping
	public String deleteProduct(Product product, Errors errors) {
		
		if(errors.hasErrors())
			return "delete";
		
		productRepo.deleteById(product.getCode());
		
		
		return "redirect:display";
	}
}
