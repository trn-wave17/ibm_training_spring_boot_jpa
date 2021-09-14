package com.ibm.training.spring.boot.jpa.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/api")
public class HomeController {
	
	@GetMapping(value="/")
	public String getHome() {
		return "home.jsp";
	}
	
	@GetMapping(value="/login")
	public String login(){
		return "login.jsp";
	}

}
