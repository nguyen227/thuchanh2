package productMaintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import productMaintenance.model.Product;
import productMaintenance.repository.ProductRepository;

@Controller
@RequestMapping("/update")
@Slf4j
public class sonUpdateController {
	
	@Autowired
	private ProductRepository productRepo;

	@GetMapping
	public String updateProduct(@RequestParam(name="code") String code, Model model){
		log.info(code);
		model.addAttribute("product", productRepo.findByCode(code));
		return "update";
	}
	
	@PostMapping
	public String updateProductPost(Product product, Errors errors) {
		if(errors.hasErrors()) {
			return "update";
		}
		int length = (product.getCode().length()-1)/2;
		product.setCode(product.getCode().substring(0, length));
		
		Product result = productRepo.save(product);

		return "redirect:display";
	}
}