package com.koreait.restproject.rest.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.restproject.exception.MemberListException;
import com.koreait.restproject.message.Message;

import lombok.extern.slf4j.Slf4j;

//Rest 요청에 대한 예외처리
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	//회원 목록을 가져올 때 발생하는 예외 처리
	@ExceptionHandler(MemberListException.class)
	@ResponseBody
	public ResponseEntity<Message> handle(MemberListException e) {
		Message message = new Message();
		message.setMsg(e.getMessage());
		message.setStatusCode(500);

		ResponseEntity entity = new ResponseEntity<Message>(message,null, HttpStatus.INTERNAL_SERVER_ERROR);
		
		log.debug("Rest 요청 시 발생하는 예외처리");
		
		return entity;
	}
}
