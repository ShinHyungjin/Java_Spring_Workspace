package com.hardware.test.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hardware.test.model.domain.Hardware;

@Repository
public class MybatisHardwareDAO implements HardwareDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Hardware.selectAll");
	}

	@Override
	public Hardware select(int hardware_id) {
		return null;
	}

	@Override
	public void insert(Hardware hardware) {
	}

	@Override
	public void update(Hardware hardware) {
	}

	@Override
	public void delete(int hardware_id) {
	}

}
