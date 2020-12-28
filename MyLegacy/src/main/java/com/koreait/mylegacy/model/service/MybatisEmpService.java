package com.koreait.mylegacy.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.mylegacy.model.dao.MybatisDeptDAO;
import com.koreait.mylegacy.model.dao.MybatisEmpDAO;
import com.koreait.mylegacy.model.domain.Emp;
import com.koreait.mylegacy.mybatis.config.MybatisConfigManager;

@Service
public class MybatisEmpService {
	@Autowired
	private MybatisConfigManager manager;
	@Autowired
	private MybatisEmpDAO mybatisEmpDAO;
	@Autowired
	private MybatisDeptDAO mybatisDeptDAO;
	
	public List selectAll() {
		List list = new ArrayList();
		SqlSession sqlSession = manager.getSqlSession();
		mybatisEmpDAO.setSqlSession(sqlSession);
		list = mybatisEmpDAO.selectAll();
		manager.close(sqlSession);
		
		return list;
	}
	
	public int regist(Emp emp) {
		int result = 0;
		SqlSession sqlSession = manager.getSqlSession();
		
		mybatisEmpDAO.setSqlSession(sqlSession);
		mybatisDeptDAO.setSqlSession(sqlSession);
		
		mybatisEmpDAO.insert(emp);
		mybatisDeptDAO.insert(emp.getDept());
		
		
		manager.close(sqlSession);
		
		return result;
		
	}
	
}
