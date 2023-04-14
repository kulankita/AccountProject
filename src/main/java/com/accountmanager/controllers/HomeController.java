package com.accountmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/menu")
	public String getPage() {
		return "menubar";
	}
	
    @GetMapping("/home")
	public String getPage2() {
		return "home";
	}

}
