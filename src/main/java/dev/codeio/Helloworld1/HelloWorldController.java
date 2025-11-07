package dev.codeio.Helloworld1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")
	String sayHelloWorld() {
		return "Hello World!";
	}
}
 