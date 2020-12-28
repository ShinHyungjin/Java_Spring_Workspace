package com.koreait.mylegacy.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koreait.mylegacy.model.domain.Dept;
import com.koreait.mylegacy.model.domain.Emp;


@Repository
public class MybatisDeptDAO {
	private SqlSession sqlSession = null;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List selectAll() {
		List list = null;
		list = sqlSession.selectList("Dept.selectAll");
		return list;
	}
	public int insert(Dept dept) {
		int result = 0;
		result = sqlSession.insert("Dept.insert", dept);
		return result;
	}
}
