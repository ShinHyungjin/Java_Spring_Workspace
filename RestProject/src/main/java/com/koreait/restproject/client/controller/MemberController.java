package com.koreait.restproject.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.restproject.rest.model.domain.Member;
import com.koreait.restproject.rest.model.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member")
	public List getList() {
		log.debug("리스트 요청");
		List<Member> memberList = memberService.selectAll();
		
		return memberList;
	}
	
}
