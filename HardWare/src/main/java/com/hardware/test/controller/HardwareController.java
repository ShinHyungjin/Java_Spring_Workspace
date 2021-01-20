package com.hardware.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hardware.test.model.domain.Hardware;
import com.hardware.test.model.service.HardwareService;

@Controller
public class HardwareController {
	@Autowired
	private HardwareService hardwareService;
	
	@RequestMapping(value="/hardware/list", method = RequestMethod.GET)
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView("list");
		List<Hardware> hardwareList = hardwareService.selectAll();
		mav.addObject("hardwareList", hardwareList);
		return mav;
	}
	
}
