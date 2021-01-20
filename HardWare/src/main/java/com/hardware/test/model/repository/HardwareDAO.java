package com.hardware.test.model.repository;

import java.util.List;

import com.hardware.test.model.domain.Hardware;

public interface HardwareDAO {
	public List selectAll();
	public Hardware select(int hardware_id);
	public void insert(Hardware hardware);
	public void update(Hardware hardware);
	public void delete(int hardware_id);
		
}
