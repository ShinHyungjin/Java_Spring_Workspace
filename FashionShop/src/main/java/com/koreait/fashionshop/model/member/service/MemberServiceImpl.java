package com.koreait.fashionshop.model.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.common.MailSender;
import com.koreait.fashionshop.common.SecureManager;
import com.koreait.fashionshop.exception.MailSendException;
import com.koreait.fashionshop.exception.MemberRegistException;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	//메일발송 객체
	@Autowired
	private MailSender mailSender;
	
	//암호 객체
	@Autowired
	private SecureManager secureManager;
	
	
	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Member select(int member_id) {
		return null;
	}

	@Override
	public void regist(Member member) throws MemberRegistException, MailSendException{
		member.setPassword(secureManager.getSecureData(member.getPassword()));
		memberDAO.insert(member);
		//mailSender.send(member.getEmail_id()+"@"+member.getEmail_server(), member.getName() + "님 [FashionShop] 가입을 축하드립니다!", "감사함다");
	}

	@Override
	public void update(Member member) {
	}

	@Override
	public void delete(Member member) {
	}

}
