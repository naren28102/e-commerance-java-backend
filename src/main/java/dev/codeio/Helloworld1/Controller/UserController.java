package dev.codeio.Helloworld1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.codeio.Helloworld1.DTO.ProductTO;
import dev.codeio.Helloworld1.DTO.UserData;
import dev.codeio.Helloworld1.Repository.UserRepository;
import dev.codeio.Helloworld1.service.UserService;

@RestController
@RequestMapping("/product")
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	ProductTO productTO;
	@GetMapping("/Alluser")
	public List<UserData> getUsers() {
		
		return userrepository.findAll();
	}
	
	@GetMapping("/name")
	public UserData getUserByName(@RequestParam Long id) {
		UserData userData=userrepository.getById(null);
		
		return userData;
	}
	
	@GetMapping("/ProductName")
	public String getProductByName() {
		return productTO.getProductName();
		
	}
	
	//get data from postman and save to database of user
	@PostMapping("/user")
	public UserData getProduct(@RequestBody UserData userData) {
		
		return userrepository.save(userData);
	}	
	
	
}
