package com.koreait.restproject.rest.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.restproject.rest.model.domain.Member;
import com.koreait.restproject.rest.model.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member")
	public ResponseEntity<List<Member>> getList() {
		log.debug("리스트 요청");
		List<Member> memberList = memberService.selectAll();
		
		ResponseEntity entity = ResponseEntity.ok().body(memberList);
		
		return entity;
	}
	@PostMapping("/member")
	public String regist(@RequestBody Member member) {
		log.debug("Post의 등록 요청");
		log.debug("m_id : " + member.getM_id());
		log.debug("m_pass : " + member.getM_pass());
		log.debug("m_name : " + member.getM_name());
		
		memberService.regist(member);
		
		return "regist success!";
	}
}
