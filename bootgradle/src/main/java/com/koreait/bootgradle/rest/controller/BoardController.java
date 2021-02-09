package com.koreait.bootgradle.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.bootgradle.model.domain.Board;

@Controller
public class BoardController {
	
	@GetMapping("/rest/board/{board_id}")
	@ResponseBody
	public Board getDetail(@PathVariable int board_id) {
		Board board = new Board();
		board.setBoard_id(board_id);
		board.setTitle("난 vo야");
		
		return board;
	}
}
