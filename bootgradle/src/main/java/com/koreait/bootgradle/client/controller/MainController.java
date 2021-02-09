package com.koreait.bootgradle.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/client/main")
	public String getMain() {
		
		return "index";
	}
}
