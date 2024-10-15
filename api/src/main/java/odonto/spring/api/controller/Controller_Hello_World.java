package odonto.spring.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Controller_Hello_World {
	
	@GetMapping
	public String helloWorld() {
		return "<h1>Hello World</h1>";
	}
}
