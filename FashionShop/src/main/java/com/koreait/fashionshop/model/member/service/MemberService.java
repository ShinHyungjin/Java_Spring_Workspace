package com.koreait.fashionshop.model.member.service;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;

public interface MemberService {
	public List selectAll(); //모든 상품 
	public Member select(Member member);
	public void regist(Member product);
	public void update(Member product);
	public void delete(Member product);
}
