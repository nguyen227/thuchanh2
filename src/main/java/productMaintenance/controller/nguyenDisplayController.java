package productMaintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import productMaintenance.model.Product;
import productMaintenance.repository.ProductRepository;

@Controller
@RequestMapping("/display")
@Slf4j
public class nguyenDisplayController {
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping()
	public String displayProductsForm(Model model) {
		List<Product> products = (List<Product>) productRepo.findAll();
		model.addAttribute("products", products);
		log.info(products.toString());
		return "display";
	}
}
