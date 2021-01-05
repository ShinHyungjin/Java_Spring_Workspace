package com.koreait.fashionshop.model.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int product_id;
	private SubCategory subCategory;
	private String product_name;
	private int price;
	private String brand;
	private String detail;
	private String filename; // currentTimes로 받아올꺼
	
	//이미지 하나를 자동으로 처리하는 객체 선언 단 이름은 html의 컴포넌트 파라미터명과 일치시켜야함
	private MultipartFile repImg; // 대표이미지
	private MultipartFile [] addImg; // 추가이미지
	
	private Color [] color;
	private Psize [] psize;
	
	
}
