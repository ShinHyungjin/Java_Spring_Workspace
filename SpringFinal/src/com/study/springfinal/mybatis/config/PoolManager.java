package com.study.springfinal.mybatis.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.jdbc.pool.DataSource;

public class PoolManager {
	private static PoolManager instance = null;
	InitialContext context;
	DataSource ds;
	Connection con;

	private PoolManager() {
			try {
				context = new InitialContext();
				ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
				con = ds.getConnection();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
	}

	public static PoolManager getConnection() {
		if (instance == null)
			instance = new PoolManager();
		return instance;
	}
	
	public void freeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
