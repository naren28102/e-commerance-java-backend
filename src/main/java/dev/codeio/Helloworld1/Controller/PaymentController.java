package dev.codeio.Helloworld1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.codeio.Helloworld1.DTO.PaymentData;
import dev.codeio.Helloworld1.DTO.ProductData;
import dev.codeio.Helloworld1.DTO.UserData;
import dev.codeio.Helloworld1.Repository.PaymentRepository;
import dev.codeio.Helloworld1.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentservice;
	@Autowired
	PaymentRepository paymentrepository;
	
	//get all payment for 
	@GetMapping("/Allpayment")
	public List<PaymentData> getPayments(){
		return paymentrepository.findAll();
	}
	@GetMapping("/getBystatus")
	public List<PaymentData> getpaymentsByStatus(@RequestParam String status){
		List<PaymentData> paymentData = paymentrepository.findByStatus(status);
		return paymentData;
		 
	}
	// create payment and save to database
	@PostMapping("/createPayment")
	public PaymentData getProductData() {
		PaymentData payment = paymentservice.getPayment();
		return paymentrepository.save(payment);
	}
	
	@PostMapping("/AddPayment")
	public PaymentData getProduct(@RequestBody PaymentData paymentData) {
		
		return paymentrepository.save(paymentData);
	}
	
	@PutMapping("/updatePayment")
	public PaymentData updateProduct(@RequestParam Long id, @RequestBody PaymentData updatedPayment) {

	    // Find existing product by ID
	     PaymentData existingProduct = paymentrepository.findById(id).orElse(null);

	    if (existingProduct != null) {
	        // Update only the fields you want from JSON body
	        existingProduct.setAmount(updatedPayment.getAmount());
	        existingProduct.setPaymentMethod(updatedPayment.getPaymentMethod());
	        existingProduct.setStatus(updatedPayment.getStatus()); // if applicable
	        existingProduct.setTransactionId(updatedPayment.getTransactionId());

	        // Save and return updated product
	        return paymentrepository.save(existingProduct);
	    }

	    // If product not found
	    throw new RuntimeException("Product not found with ID: " + id);
	}
	@DeleteMapping("/deleteByID")
	public String deleteByRequestValue(@RequestParam Long Id) {
		paymentrepository.deleteById(Id);
		return "Deleted row ";
		
	}
	
}
