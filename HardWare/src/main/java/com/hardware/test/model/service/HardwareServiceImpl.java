package com.hardware.test.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardware.test.model.repository.HardwareDAO;

@Service
public class HardwareServiceImpl implements HardwareService{
	@Autowired
	private HardwareDAO hardwareDAO;
	
	@Override
	public List selectAll() {
		return hardwareDAO.selectAll();
	}

}
