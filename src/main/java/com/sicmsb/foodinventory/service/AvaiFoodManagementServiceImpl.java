package com.sicmsb.foodinventory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.dto.AvaiFoodItemDTO;
import com.sicmsb.foodinventory.dto.AvaiFoodManagementDTO;
import com.sicmsb.foodinventory.model.AvaiFoodItem;
import com.sicmsb.foodinventory.model.AvaiFoodManagement;
import com.sicmsb.foodinventory.repository.AvaiFoodManagementRepository;

@Transactional
@Service
public class AvaiFoodManagementServiceImpl implements AvaiFoodManagementService {

	@Inject
	private AvaiFoodManagementRepository avaiFoodManagementRepository;

	@Override
	public AvaiFoodManagement createFoodManagement(AvaiFoodManagementDTO avaiFoodManagementDTO) {

		// get data from avaiFoodManagement DTO (payload) to avaiFoodManagement model
		// (repository - save to avaiFoodManagementDB)
		AvaiFoodManagement avaiFoodMgnt = new AvaiFoodManagement();
		avaiFoodMgnt.setStartDate(avaiFoodManagementDTO.getStartDate());
		avaiFoodMgnt.setEndDate(avaiFoodManagementDTO.getEndDate());
		avaiFoodMgnt.setCreatedBy("1");
		avaiFoodMgnt.setCreatedDate(new Date());

		return avaiFoodManagementRepository.save(avaiFoodMgnt);

	}

	@Override
	@Transactional(readOnly = true)
	public AvaiFoodManagementDTO getCurrPerFoodManagement() {
		Date currPer = new Date();
		AvaiFoodManagementDTO avaiFoodManagementDTO = new AvaiFoodManagementDTO();
		AvaiFoodManagement avaiFoodManagement = avaiFoodManagementRepository.findCurrPerFoodManagement(currPer)
				.orElse(new AvaiFoodManagement());
		avaiFoodManagementDTO.setStartDate(avaiFoodManagement.getStartDate());
		avaiFoodManagementDTO.setEndDate(avaiFoodManagement.getEndDate());
		List<AvaiFoodItemDTO> avaiFoodItemDtos = new ArrayList<>();
		for (AvaiFoodItem avaiFoodItem : avaiFoodManagement.getAvaiFoodItems()) {
			AvaiFoodItemDTO avaiFoodItemDTO = new AvaiFoodItemDTO(avaiFoodItem.getId(), avaiFoodItem.getFoodName());
			avaiFoodItemDtos.add(avaiFoodItemDTO);

		}
		avaiFoodManagementDTO.setAvailableFoodItemList(avaiFoodItemDtos);

		return avaiFoodManagementDTO;

	}

}
