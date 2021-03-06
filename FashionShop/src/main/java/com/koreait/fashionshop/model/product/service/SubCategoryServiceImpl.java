package com.koreait.fashionshop.model.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.model.domain.SubCategory;
import com.koreait.fashionshop.model.product.repository.SubCategoryDAO;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	
	@Autowired
	private SubCategoryDAO subCategoryDAO;

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public List selectAllById(int topcategory_id) {
		return subCategoryDAO.selectAllById(topcategory_id);
	}

	@Override
	public SubCategory select(int subcategory_id) {
		return null;
	}

	@Override
	public void insert(SubCategory subcategory) {
	}

	@Override
	public void update(SubCategory subcategory) {
	}

	@Override
	public void delete(int subcategory_id) {
	}

}
