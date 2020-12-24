package com.study.springfinal.controller.gallery;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.study.springfinal.common.FileManager;
import com.study.springfinal.domain.Gallery;
import com.study.springfinal.model.dao.GalleryDAO;

@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	@Autowired
	private GalleryDAO galleryDAO;
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(Gallery gallery, HttpServletRequest request) {
		
		MultipartFile photo = gallery.getPhoto();
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getName());
		System.out.println(photo.getContentType());
		System.out.println(photo.getSize());
		
		String newName = Long.toString(System.currentTimeMillis());
		String ext = FileManager.getExtend(photo.getOriginalFilename());
		String filename = newName + "." + ext;
		gallery.setFilename(filename);
		
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath("/data");
		
		System.out.println(realPath);
		
		try {
			photo.transferTo(new File(realPath + "/" + filename));

			int result = galleryDAO.insert(gallery);
			System.out.println("등록결과 : " + result);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/gallery/list";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView selectAll() {
		List galleryList = galleryDAO.selectAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("galleryList", galleryList);
		mav.setViewName("gallery/list");
		
		return mav;
	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public ModelAndView select(int gallery_id) {
		ModelAndView mav = new ModelAndView();
		Gallery gallery = galleryDAO.select(gallery_id);
		
		mav.addObject("gallery",gallery);
		mav.setViewName("gallery/detail");
			
		return mav;
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String edit(Gallery gallery) {
		galleryDAO.update(gallery);
		return "redirect:/gallery/detail?gallery_id="+gallery.getGallery_id();
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(int gallery_id) {
		galleryDAO.delete(gallery_id);
		return "redirect:/gallery/list";
	}
	
}
