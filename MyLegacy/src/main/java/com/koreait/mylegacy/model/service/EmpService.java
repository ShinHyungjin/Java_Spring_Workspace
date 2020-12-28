package com.koreait.mylegacy.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.mylegacy.model.dao.JdbcDeptDAO;
import com.koreait.mylegacy.model.dao.JdbcEmpDAO;
import com.koreait.mylegacy.model.domain.Dept;
import com.koreait.mylegacy.model.domain.Emp;
import com.koreait.mylegacy.model.pool.PoolManager;

@Service
public class EmpService {
	@Autowired
	private PoolManager poolManager;
	@Autowired
	private JdbcDeptDAO jdbcDeptDAO;
	@Autowired
	private JdbcEmpDAO jdbcEmpDAO;

	public List selectAll() {
		List list = null;
		Connection con = poolManager.getConnection();
		jdbcEmpDAO.setCon(con);
		list = jdbcEmpDAO.selectAll();
		return list;
	}

	public Dept selectDept(int deptno) {
		Dept dept = null;

		return dept;

	}

	public Emp selectEmp(int empno) {
		Emp emp = null;

		return emp;
	}

	public int regist(Emp emp) {
		int result = 0;
		Connection con = poolManager.getConnection();

		jdbcDeptDAO.setCon(con);
		jdbcEmpDAO.setCon(con);

		try {
			con.setAutoCommit(false);
			result = jdbcDeptDAO.regist(emp.getDept());
			result = jdbcEmpDAO.regist(emp);
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally {
				try {
					con.setAutoCommit(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		poolManager.freeConnection(con);
		return result;
	}

	public int updateDept(Dept dept) {
		int result = 0;

		return result;
	}

	public int updateEmp(Emp emp) {
		int result = 0;

		return result;
	}

	public int deleteDept(int deptno) {
		int result = 0;

		return result;
	}

	public int deleteEmp(int empno) {
		int result = 0;

		return result;
	}

}
