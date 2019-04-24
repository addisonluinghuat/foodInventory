package com.sicmsb.foodinventory.service;

import java.util.List;

import com.sicmsb.foodinventory.dto.AvaiFoodItemDTO;
import com.sicmsb.foodinventory.dto.AvaiFoodManagementDTO;
import com.sicmsb.foodinventory.model.AvaiFoodItem;
import com.sicmsb.foodinventory.model.AvaiFoodManagement;

public interface AvaiFoodItemService {

	public List<AvaiFoodItemDTO> getAvaiFoodItem();
	public AvaiFoodItem createFoodItem(AvaiFoodItemDTO avaiFoodItemDTO); 

}
