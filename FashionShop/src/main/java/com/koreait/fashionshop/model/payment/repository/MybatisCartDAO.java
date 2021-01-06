package com.koreait.fashionshop.model.payment.repository;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.CartException;
import com.koreait.fashionshop.model.domain.Cart;

@Repository
public class MybatisCartDAO implements CartDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public List selectAll(int member_id) {
		return null;
	}

	@Override
	public Cart select(int cart_id) {
		return null;
	}

	@Override
	public void insert(Cart cart) throws CartException{
		int result = sqlSessionTemplate.insert("Cart.insert",cart);
		if(result ==0) {
			throw new CartException("장바구니에 담기 실패!");
		}
	}

	@Override
	public void update(Cart cart) {
	}

	@Override
	public void delete(Cart cart) {
	}

	
}
