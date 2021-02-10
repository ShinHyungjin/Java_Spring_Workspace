package com.koreait.bootgradle.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminBoardController {
	
	@GetMapping("/admin/board")
	public String getBoard() {
		
		return "admin/board/list";
	}
}
