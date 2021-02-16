package com.koreait.bootgradle.model.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Photo {
	private int photo_id;
	private String title;
	private String filename;
	private MultipartFile myFile;
}
