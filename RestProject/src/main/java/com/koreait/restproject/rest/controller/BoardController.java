package com.koreait.restproject.rest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.koreait.restproject.exception.BoardUpdateException;
import com.koreait.restproject.message.Message;
import com.koreait.restproject.model.board.service.BoardService;
import com.koreait.restproject.model.domain.Board;
import com.koreait.restproject.rest.websocket.MyWebSocketHandler;
import com.koreait.restproject.rest.websocket.SocketMessage;

import lombok.extern.slf4j.Slf4j;

@RestController   //restful url을 이해한다, 또한 @ResponseBody가 이미 처리
@Slf4j
public class BoardController {
	Gson gson = new Gson();
	@Autowired
	private BoardService boardService;
	@Autowired
	private MyWebSocketHandler myWebSocketHandler;
	
	//목록가져오기 요청
	@GetMapping("/board") //이미 ResponseBody가 적용된 상태이므로, 컨버터만 등록해놓았다면,List는 자동으로
	//Json으로 변환되어 클라이언트의 응답 정보로 사용됨...
	public List<Board> getList() {
		List boardList = boardService.selectAll();
		return boardList;
	}
	
	
	//한건 가져오기 요청 
	@GetMapping("/board/{board_id}")
	public Board getDetail(@PathVariable int board_id) {
		log.debug("파라미터 : " + board_id);		
		return boardService.select(board_id);
	}
	
	//등록 요청 
	@PostMapping("/board")
	//@RequestBody : 클라이언트가 전송한 json데이터를 자바의 객체로 변환  (json --> java로 변환)
	public ResponseEntity<Board> regist(@RequestBody Board board) {
		log.debug("title is "+board.getTitle());
		log.debug("writer is "+board.getWriter());
		log.debug("content is "+board.getContent());
		
		boardService.regist(board);
		
		SocketMessage msg = new SocketMessage();
		msg.setRequestCode("create");
		msg.setResultCode(200);
		msg.setMsg("등록성공");
		
		String jsonString  = gson.toJson(msg);
		
		myWebSocketHandler.broadCast(jsonString);
		
		return ResponseEntity.ok().body(board);//board_id가 이미 채워진 vo
	}
	//수정 요청 
	@PutMapping("/board")
	public ResponseEntity update(@RequestBody Board board) {
		log.debug("board_id is "+board.getBoard_id());
		log.debug("title is "+board.getTitle());
		log.debug("writer is "+board.getWriter());
		log.debug("content is "+board.getContent());
		
		boardService.update(board);
		
		SocketMessage msg = new SocketMessage();
		msg.setRequestCode("update");
		msg.setResultCode(200);
		msg.setMsg("수정성공");
		
		String jsonString  = gson.toJson(msg);
		
		myWebSocketHandler.broadCast(jsonString);
		
		return ResponseEntity.ok().body(board);
	}
	
	//삭제 요청
	@DeleteMapping("/board/{board_id}")
	public ResponseEntity<Message> delete(@PathVariable int board_id) {
		boardService.delete(board_id);
		Message message = new Message();
		message.setMsg("게시물 삭제 성공");
		
		SocketMessage msg = new SocketMessage();
		msg.setRequestCode("delete");
		msg.setResultCode(200);
		msg.setMsg("삭제성공");
		
		String jsonString  = gson.toJson(msg);
		
		myWebSocketHandler.broadCast(jsonString);
		
		return ResponseEntity.ok().body(message);
	}
	
}




