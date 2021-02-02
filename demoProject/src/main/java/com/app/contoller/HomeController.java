package com.app.contoller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HomeController {
	public HomeController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	@RequestMapping("/")
	public String showWelcomePage() {
		System.out.println("in show welcome page");
		return "/index";//actual view name : /WEB-INF/views/index.jsp
	}
	
}
