package dev.codeio.Helloworld1.Controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.codeio.Helloworld1.DTO.ProductTO;
import dev.codeio.Helloworld1.DTO.UserData;
import dev.codeio.Helloworld1.Repository.UserRepository;
import dev.codeio.Helloworld1.service.UserService;

@RestController
@RequestMapping("/user")
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
	
	@GetMapping("/id")
	public Optional<UserData> getUserById(@RequestParam Long id) {
		Optional<UserData> userData=userrepository.findById(id);
		
		return userData;
	}
	@GetMapping("/name")
	public Optional<UserData> getUserByName(@RequestParam String name){
		Optional<UserData> userData = userrepository.findByName(name);
		return userData;
	}

	@GetMapping("/ProductName")
	public String getProductByName() {
		return productTO.getProductName();
	}
	@PutMapping("/updateUser")
	public UserData updateUser(@RequestParam Long id,@RequestBody UserData updatedUser) {
		UserData existingProduct = userrepository.findById(id).orElse(null);
		
		if (existingProduct != null) {
			existingProduct.setName(updatedUser.getName());
			existingProduct.setAddress(updatedUser.getAddress());
			existingProduct.setPhoneNumber(updatedUser.getPhoneNumber());
			
			return userrepository.save(existingProduct);
		}
		
		throw new RuntimeException("User not found with this ID:" + id);
	}
	//get data from postman and save to database of user
	@PostMapping("/AddUser")
	public UserData addUser(@RequestBody UserData userData) {
		
		return userrepository.save(userData);
	}
	@PostMapping("/Add")
	public UserData modifyAndAdd() {
		return null;
		
	}
	
	@DeleteMapping("deleteByID")
	public String deleteByRequestValue(@RequestParam Long id) {
		userrepository.deleteById(id);
		return "Deleted row";
	}
}
