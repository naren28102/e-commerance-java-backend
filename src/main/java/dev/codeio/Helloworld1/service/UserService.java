package dev.codeio.Helloworld1.service;

import org.springframework.stereotype.Service;
import dev.codeio.Helloworld1.DTO.UserData;


@Service
public class UserService {
	public UserData getUser() {
		UserData u1 = new UserData();
		u1.setName("Yogeshwaran");
		u1.setEmail("subramainyaSIpolice123@gmail.com");
		u1.setPhoneNumber("7904110338");
		u1.setAddress("NO 49/14 Mayladurai");
		return u1;
		
	}	
}
