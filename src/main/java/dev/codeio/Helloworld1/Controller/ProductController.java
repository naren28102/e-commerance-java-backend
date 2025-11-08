package dev.codeio.Helloworld1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.codeio.Helloworld1.DTO.ProductData;
import dev.codeio.Helloworld1.DTO.ProductTO;
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

	@Autowired
	ProductTO productTO;
	
	// get all products from database
	@GetMapping("/Allproducts")
	public List<ProductData> getproducts() {

		return productrepository.findAll();
	}

	// create product and save to database
	@PostMapping("/products")
	public ProductData getProductData() {
		ProductData product = productservice.getProduct();
		return productrepository.save(product);
	}

	// delete product by id by hardcoded va
	@DeleteMapping("/deleteproduct")
	public String deleteProduct() {
		Long id = (long) 1;
		productrepository.deleteById(id);
		return "Product Deleted Successfully";
	}

	// Update product by id
	@PutMapping("/updateproduct")
	public ProductData updateProduct() {
		Long id =(long) 2;
//		ProductData productData = new ProductData();
//		productData.setProductName("Gnanu");
//		productData.setDescription("New Description Updates");
		
		
		ProductData existingProduct = productrepository.findById(id).orElse(null); // Fetch existing product from the database
		productTO.setProductName(existingProduct.getProductName());
		
		if (existingProduct != null) {
			existingProduct.setProductName("Gnanu");
			existingProduct.setDescription("Created deletd");
			
			return productrepository.save(existingProduct);
		}
		return null;
	}

	// delete product by id using values from end point request
	@DeleteMapping("/deleteByID")
	public String deleteByRequestValue(@RequestParam Long Id) {
		productrepository.deleteById(Id);
		
		return "Deleted row ";
		
	}
	
	

}
