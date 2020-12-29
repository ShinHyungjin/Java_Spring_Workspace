package com.koreait.mvclegacy.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvclegacy.model.member.MemberService;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	//ALL < DEBUG < INFO < WARN < ERROR < FATAR < OFF
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String test() {
		logger.debug("Admin의 test() 호출");
		logger.debug(memberService.toString());
		
		
		memberService.regist();
		return null;
	}
}
