package dev.codeio.Helloworld1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.codeio.Helloworld1.DTO.UserData;
import dev.codeio.Helloworld1.Repository.UserRepository;
import dev.codeio.Helloworld1.service.UserService;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/product")
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	UserRepository userrepository;
	@GetMapping("/Alluser")
	public List<UserData> getUsers() {
		
		return userrepository.findAll();
	}
	@PostMapping("/user")
	public UserData getProduct() {
		UserData user= userservice.getUser();
		return userrepository.save(user);
	}	
}
