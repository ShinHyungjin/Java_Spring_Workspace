package com.koreait.restproject.rest.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.koreait.restproject.rest.model.domain.Member;

@Repository
public class MybatisMemberDAO implements MemberDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
		
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Member.selectAll");
	}

	@Override
	public void insert(Member member) throws RuntimeException{
		int result = sqlSessionTemplate.insert("Member.insert", member);
		if(result == 0) {
			throw new RuntimeException("등록 실패");
		}
	}

	@Override
	public Member select(int member_id) {
		return null;
	}

	@Override
	public void update(Member member) {
	}

	@Override
	public void delete(int member_id) {
	}

}
