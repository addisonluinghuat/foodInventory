package com.sicmsb.foodinventory.service;

import java.util.Optional;

import com.sicmsb.foodinventory.model.EmployeeInfo;

public interface EmployeeInfoService {

	public Optional<EmployeeInfo> getEmployeeInfoById(Long id);

}
