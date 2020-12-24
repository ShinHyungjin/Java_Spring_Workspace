<%@page import="com.study.springfinal.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.study.springfinal.mybatis.config.MybatisConfigManager"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%!
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
%>

<%
	
	//InitialContext context = new InitialContext();
	//DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");

	//out.print(ds.getConnection());
	
	// 서비스 영역
	SqlSession sqlSession = manager.getSqlSession();
	List<Emp> list = sqlSession.selectList("Emp.selectAll");
	
	out.print("검색된 총 사원수와 부모수 : " + list.size());


%>