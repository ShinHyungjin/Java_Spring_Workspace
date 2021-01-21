package com.koreait.restproject.rest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.restproject.rest.model.domain.Member;
import com.koreait.restproject.rest.model.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List selectAll() {
		return memberDAO.selectAll();
	}

	@Override
	public Member select(int member_id) {
		return null;
	}

	@Override
	public void regist(Member member) throws RuntimeException{
		memberDAO.insert(member);
	}

	@Override
	public void update(Member member) {
	}

	@Override
	public void delete(int member_id) {
	}

}
