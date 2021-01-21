package com.koreait.restproject.rest.model.service;

import java.util.List;

import com.koreait.restproject.rest.model.domain.Member;

public interface MemberService {
	public List selectAll();
	public Member select(int member_id);
	public void regist(Member member);
	public void update(Member member);
	public void delete(int member_id);
}
