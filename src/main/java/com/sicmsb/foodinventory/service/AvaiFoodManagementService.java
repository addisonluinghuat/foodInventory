package com.sicmsb.foodinventory.service;

import com.sicmsb.foodinventory.dto.AvaiFoodManagementDTO;
import com.sicmsb.foodinventory.exception.BaseException;
import com.sicmsb.foodinventory.model.AvaiFoodManagement;

public interface AvaiFoodManagementService {

	public AvaiFoodManagement createFoodManagement(AvaiFoodManagementDTO avaiFoodManagementDTO) throws BaseException;

	public AvaiFoodManagementDTO getCurrPerFoodManagement();

}
