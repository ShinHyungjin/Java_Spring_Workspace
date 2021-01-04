package com.koreait.fashionshop.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.model.domain.Psize;

@Repository
public class MybatisPsizeDAO implements PsizeDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		List list = null;
		return list;
	}

	@Override
	public List selectById(int product_id) {
		List list = null;
		return list;
	}

	@Override
	public Psize select(int psize_id) {
		Psize psize = null;
		return psize;
	}

	@Override
	public void insert(Psize psize) {
		sqlSessionTemplate.insert("Psize.insert",psize);
	}

	@Override
	public void update(Psize psize) {
		
	}

	@Override
	public void delete(int psize_id) {
		
	}

}
