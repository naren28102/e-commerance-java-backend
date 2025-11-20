package dev.codeio.Helloworld1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private static final String HttpStatus = null;
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
	@GetMapping("/productByname")
	public List<ProductData> getProductByName(@RequestParam String product_name) {
		List<ProductData> productData = productrepository.findByProductName(product_name);
		return productData;
	}
//	@GetMapping("/product")
//	public ResponseEntity<ProductData> getProductById(@RequestParam Long id) {
//	    try {
//	        return productrepository.findById(id)
//	            .map(product -> ResponseEntity.ok(product))
//	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
//	                .body("Product not found with ID: " + id));
//	    } catch (Exception e) {
//	        e.printStackTrace(); // helpful for debugging
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	            .body("Error fetching product: " + e.getMessage());
//	    }
//	}
	

    
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
		Long id =(long) 3;
//		ProductData productData = new ProductData();
//		productData.setProductName("Gnanu");
//		productData.setDescription("New Description Updates");
		
		
		ProductData existingProduct = productrepository.findById(id).orElse(null); // Fetch existing product from the database
		productTO.setProductName(existingProduct.getProductName());
		
		if (existingProduct != null) {
			existingProduct.setProductName("Gnanu");
			existingProduct.setDescription("Created deletd");
			existingProduct.setPrices("2500");
			
			return productrepository.save(existingProduct);
		}
		return null;
	}
	@PutMapping("/updateProduct")
	public ProductData updateProduct(@RequestParam Long id, @RequestBody ProductData updatedProduct) {

	    // Find existing product by ID
	    ProductData existingProduct = productrepository.findById(id).orElse(null);

	    if (existingProduct != null) {
	        // Update only the fields you want from JSON body
	        existingProduct.setProductName(updatedProduct.getProductName());
	        existingProduct.setDescription(updatedProduct.getDescription());
	        existingProduct.setPrices(updatedProduct.getPrices()); // if applicable

	        // Save and return updated product
	        return productrepository.save(existingProduct);
	    }

	    // If product not found
	    throw new RuntimeException("Product not found with ID: " + id);
	}
	@PutMapping("/{id}/{name}")
	public void update(@PathVariable("id") Long id, @PathVariable("name") String name) {
		productrepository.updateName(id, name);
	}
	
	@PutMapping
	public void updateWithParams(@RequestParam Long id,@RequestParam String name) {
		productrepository.updateName(id, name);
	}


	// delete product by id using values from end point request
	@DeleteMapping("/deleteByID")
	public String deleteByRequestValue(@RequestParam Long Id) {
		productrepository.deleteById(Id);
		return "Deleted row ";
		
	}
	
	@DeleteMapping("/deleteByID/{id}")
	public String deleteById(@PathVariable Long id) {
	    productrepository.deleteById(id);
	    return "Deleted row";
	}

	

}
