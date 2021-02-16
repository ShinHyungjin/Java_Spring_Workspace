package com.koreait.bootgradle.model.service.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.bootgradle.model.domain.Photo;
import com.koreait.bootgradle.model.photo.repository.PhotoDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService{
	
	@Autowired
	private PhotoDAO photoDAO;

	public void regist(Photo photo) {
		log.debug("regist() 호출");
		photoDAO.insert(photo);
	}
}