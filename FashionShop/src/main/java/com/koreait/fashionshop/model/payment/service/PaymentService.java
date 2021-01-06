package com.koreait.fashionshop.model.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.fashionshop.model.domain.Cart;

@Service
public interface PaymentService {
	public List selectCartList();
	public List selectCartList(int member_id);
	public Cart selectCart(int cart_id);	
	public void insert(Cart cart);
	public void update(Cart cart);
	public void delete(Cart cart);
}
