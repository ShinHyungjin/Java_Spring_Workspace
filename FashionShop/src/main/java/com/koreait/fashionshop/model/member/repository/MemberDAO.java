package com.koreait.fashionshop.model.member.repository;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;

public interface MemberDAO {
	public List selectAll();
	public Member select(int member_id);
	public void insert(Member member);
	public void update(Member member);
	public void delete(Member member);	//회원 삭제는 좀 더 따져봐야 할 조건이 있을 수 있으므로 더 넓은 범위인 VO를 이용 (의무적인건 아님)
}
