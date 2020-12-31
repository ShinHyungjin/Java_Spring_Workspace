package com.koreait.fashionshop.model.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.fashionshop.model.domain.Product;

@Service
public interface ProductService {
	public List selectAll(); //모든 상품 
	public List selectById(int subcategory_id); //하위 카테고리에 소속된 모든 상품
	public Product select(int product_id);
	public void regist(Product product); //insert뿐만 하는게 아니라, image 업로드 등의 업무처리도 필요하기 때문
	public void update(Product product);
	public void delete(int product_id);
}
