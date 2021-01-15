package com.koreait.fashionshop.model.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.model.common.FileManager;
import com.koreait.fashionshop.model.domain.Color;
import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.domain.Psize;
import com.koreait.fashionshop.model.excel.ProductConverter;
import com.koreait.fashionshop.model.product.repository.ColorDAO;
import com.koreait.fashionshop.model.product.repository.ProductDAO;
import com.koreait.fashionshop.model.product.repository.PsizeDAO;

@Service
public class DumpServiceImpl implements DumpService{
	private static final Logger logger=LoggerFactory.getLogger(DumpService.class);
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ColorDAO colorDAO;
	
	@Autowired
	private PsizeDAO psizeDAO;
	
	@Override
	public void regist(String path) {
		//엑셀을 읽어서 데이터로 넣기
		List<Product> productList = productConverter.convertFromFile(path);
		logger.debug("엑셀파일을 분석하여 나온 결과 리스트 "+productList.size());
		
		for(int i=0;i<productList.size();i++) {
			Product product = productList.get(i);
			productDAO.insert(product);
			//인서트 하자마자 이 시점부터는 product vo에 이미 pk값이 채워져 있는 상태이다..
			for(Color color : product.getColorList()) {
				color.setProduct_id(product.getProduct_id());
				colorDAO.insert(color);
			}
			for(Psize psize : product.getPsizeList()) {
				psize.setProduct_id(product.getProduct_id());
				psizeDAO.insert(psize);
			}
			product.setFilename(product.getProduct_id() +"."+ FileManager.getExtend(product.getFilename()));
			productDAO.update(product);
			
		}
	}
	
}








