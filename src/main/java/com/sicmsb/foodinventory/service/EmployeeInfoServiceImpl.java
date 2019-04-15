package com.sicmsb.foodinventory.service;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.model.EmployeeInfo;
import com.sicmsb.foodinventory.repository.EmployeeInfoRepository;

@Transactional
@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	@Inject
	private EmployeeInfoRepository employeeInfoRepository;

	@Transactional(readOnly = true)
	public Optional<EmployeeInfo> getEmployeeInfoById(Long id) {
		return employeeInfoRepository.findById(id);
	}

}
