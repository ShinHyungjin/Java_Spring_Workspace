package com.koreait.fashionshop.model.payment.repository;

import java.util.List;

import com.koreait.fashionshop.model.domain.Cart;

public interface CartDAO {
	public List selectAll();
	public List selectAll(int member_id);
	public Cart select(int cart_id);	
	public void insert(Cart cart);
	public void update(Cart cart);
	public void delete(Cart cart);
}
