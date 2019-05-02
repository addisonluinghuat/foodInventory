package com.sicmsb.foodinventory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.dto.AvaiFoodItemDTO;
import com.sicmsb.foodinventory.model.AvaiFoodItem;
import com.sicmsb.foodinventory.repository.AvaiFoodItemRepository;

@Transactional
@Service
public class AvaiFoodItemServiceImpl implements AvaiFoodItemService {

	@Inject
	private AvaiFoodItemRepository avaiFoodItemRepository;

	@Transactional(readOnly = true)
	public List<AvaiFoodItemDTO> getAvaiFoodItem() {
		// new AvaiFoodItemDTO(null, null, null);
		// return avaiFoodItemRepository.findAll().stream()
		// .map(entity -> new AvaiFoodItemDTO(entity.getId(),
		// entity.getAvaiFoodMgntId(), entity.getFoodName()))
		// .collect(Collectors.toList());
		return new ArrayList<>();

	}

	@Override
	public AvaiFoodItem createFoodItem(AvaiFoodItemDTO avaiFoodItemDTO) {

		// set available food item from avaiFoodItemDTO to AvaiFoodItem model and insert
		// to avaiFoodItem database
		AvaiFoodItem avaiFoodItem = new AvaiFoodItem();

		// avaiFoodItem.setAvaiFoodMgntId(avaiFoodItemDTO.getAvaiFoodManagementId());
		avaiFoodItem.setFoodName(avaiFoodItemDTO.getFoodName());
		avaiFoodItem.setCreatedBy("1");
		avaiFoodItem.setCreatedDate(new Date());

		return avaiFoodItemRepository.save(avaiFoodItem);
	}

}
