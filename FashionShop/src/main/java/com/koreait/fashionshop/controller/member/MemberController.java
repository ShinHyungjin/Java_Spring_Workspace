package com.koreait.fashionshop.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.common.MessageData;
import com.koreait.fashionshop.exception.MailSendException;
import com.koreait.fashionshop.exception.MemberNotFoundException;
import com.koreait.fashionshop.exception.MemberRegistException;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.member.service.MemberService;
import com.koreait.fashionshop.model.product.service.TopCategoryService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@Autowired
	private TopCategoryService topCategoryService;

	// 회원가입 폼
	@RequestMapping(value = "/shop/member/registForm", method = RequestMethod.GET)
	public ModelAndView getRegistForm() {
		ModelAndView mav = new ModelAndView();
		List topList = topCategoryService.selectAll();
		mav.addObject("topList", topList);
		mav.setViewName("shop/member/signup");
		return mav;
	}

	// 회원가입
	@RequestMapping(value = "/shop/member/regist", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String regist(Member member) {
		logger.debug("아이디 " + member.getUser_id());
		logger.debug("이름" + member.getName());
		logger.debug("비번 " + member.getPassword());
		logger.debug("이메일ID " + member.getEmail_id());
		logger.debug("이메일Server " + member.getEmail_server());
		logger.debug("우편번호 " + member.getZipcode());
		logger.debug("주소 " + member.getAddr());

		memberService.regist(member);

		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"result\":1, ");
		sb.append(" \"msg\":\"회원가입 성공!\"");
		sb.append("}");

		return sb.toString();
	}

	// 로그인 폼
	@RequestMapping(value = "/shop/member/loginForm", method = RequestMethod.GET)
	public ModelAndView getLoginForm() {
		ModelAndView mav = new ModelAndView();
		List topList = topCategoryService.selectAll();
		mav.addObject("topList", topList);
		mav.setViewName("shop/member/signin");
		return mav;
	}

	//로그인 요청 처리
	@RequestMapping(value = "/shop/member/login", method = RequestMethod.POST)
	public String login(Member member, HttpServletRequest request) {
		Member obj = memberService.select(member);
		
		HttpSession session = request.getSession();
		session.setAttribute("member", obj);
		
		return "redirect:/";
	}
	
	//로그아웃 요청 처리
	@RequestMapping(value = "/shop/member/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("로그아웃 되었습니다");
		messageData.setUrl("/");
		
		ModelAndView mav = new ModelAndView("shop/error/message");
		mav.addObject("messageData",messageData);
		
		return mav;
	}
	
	// 회원가입, 이메일, 로그인 예외처리
	@ExceptionHandler(MemberRegistException.class)
	@ResponseBody
	public String handleException(MemberRegistException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"result\":0,");
		sb.append("\"msg\":\"" + e.getMessage() + "\"");
		sb.append("}");

		return sb.toString();
	}

	@ExceptionHandler(MailSendException.class)
	public ModelAndView handleException(MailSendException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", e.getMessage());
		mav.setViewName("shop/error/result");

		return mav;
	}
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ModelAndView handlerException(MemberNotFoundException e) {
		ModelAndView mav = new ModelAndView();
		List topList = topCategoryService.selectAll();
		mav.addObject("topList", topList);
		mav.addObject("msg", e.getMessage());
		mav.setViewName("shop/error/result");
		
		return mav;
	}

}
