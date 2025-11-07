package dev.codeio.Helloworld1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.codeio.Helloworld1.DTO.ProductData;
import dev.codeio.Helloworld1.Repository.ProductRepository;
import dev.codeio.Helloworld1.Repository.UserRepository;
import dev.codeio.Helloworld1.service.ProductService;

@RestController
@RequestMapping("/search")
public class ProductController {
	@Autowired
	ProductService productservice;
	@Autowired
	ProductRepository productrepository;
	@GetMapping("/Allproducts")
	public List<ProductData> getproducts(){
		
		return productrepository.findAll();
	}
	@PostMapping("/products")
	public ProductData getProductData() {
		ProductData product = productservice.getProduct();
		return productrepository.save(product);
	}

}
