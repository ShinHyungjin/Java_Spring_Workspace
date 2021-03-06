package com.koreait.fashionshop.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.ProductRegistException;
import com.koreait.fashionshop.model.domain.Color;

@Repository
public class MybatisColorDAO implements ColorDAO{
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
	public Color select(int color_id) {
		Color color = null;
		return color;
	}

	@Override
	public void insert(Color color) throws ProductRegistException{
		int result = sqlSessionTemplate.insert("Color.insert",color);
		if(result == 0) {
			throw new ProductRegistException("색상 등록에 실패!");
		}
	}

	@Override
	public void update(Color color) throws ProductRegistException{
		
	}

	@Override
	public void delete(int psize_id) throws ProductRegistException{
		
	}

}