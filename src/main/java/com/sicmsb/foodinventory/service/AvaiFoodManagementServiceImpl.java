package com.sicmsb.foodinventory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.dto.AvaiFoodItemDTO;
import com.sicmsb.foodinventory.dto.AvaiFoodManagementDTO;
import com.sicmsb.foodinventory.exception.BaseException;
import com.sicmsb.foodinventory.model.AvaiFoodItem;
import com.sicmsb.foodinventory.model.AvaiFoodManagement;
import com.sicmsb.foodinventory.repository.AvaiFoodManagementRepository;
import com.sicmsb.foodinventory.util.DateUtil;

@Transactional
@Service
public class AvaiFoodManagementServiceImpl implements AvaiFoodManagementService {

	@Inject
	private AvaiFoodManagementRepository avaiFoodManagementRepository;

	@Override

	public AvaiFoodManagement createFoodManagement(AvaiFoodManagementDTO avaiFoodManagementDTO) throws BaseException {

		// get data from avaiFoodManagement DTO (payload) to avaiFoodManagement model
		// (repository - save to avaiFoodManagementDB)
//		Optional<AvaiFoodManagement> avaiFoodManagementOpt = avaiFoodManagementRepository
//				.findByStartDateAndEndDate(avaiFoodManagementDTO.getStartDate(), avaiFoodManagementDTO.getEndDate());

//		if (avaiFoodManagementOpt.isPresent()) {
//			throw new BaseException(102, "Duplicate");
//		}

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

		avaiFoodManagementDTO.setStartDate(DateUtil.addOneDate(avaiFoodManagement.getStartDate()));
		avaiFoodManagementDTO.setEndDate(DateUtil.addOneDate(avaiFoodManagement.getEndDate()));

		List<AvaiFoodItemDTO> avaiFoodItemDtos = new ArrayList<>();
		for (AvaiFoodItem avaiFoodItem : avaiFoodManagement.getAvaiFoodItems()) {
			AvaiFoodItemDTO avaiFoodItemDTO = new AvaiFoodItemDTO(avaiFoodItem.getId(), avaiFoodItem.getFoodName());
			avaiFoodItemDtos.add(avaiFoodItemDTO);

		}
		avaiFoodManagementDTO.setAvailableFoodItemList(avaiFoodItemDtos);

		return avaiFoodManagementDTO;

	}

	@Override
	@Transactional(readOnly = true)
	public boolean duplicateCreateFoodPeriod(Date createFoodStartDate, Date createFoodEndDate) {

		boolean isDuplicate = false;

		AvaiFoodManagement duplicateCreateFoodStartDate = avaiFoodManagementRepository
				.getBetweenFoodCreateDate(createFoodStartDate);
		AvaiFoodManagement duplicateCreateFoodEndDate = avaiFoodManagementRepository
				.getBetweenFoodCreateDate(createFoodEndDate);

		if (!(Objects.isNull(duplicateCreateFoodStartDate) && Objects.isNull(duplicateCreateFoodEndDate))) {

			isDuplicate = true;

		}

		return isDuplicate;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean checkDuplicateFood(AvaiFoodManagementDTO avaiFoodManagementDTO) {

		boolean isDuplicate = false;

		List<AvaiFoodItemDTO> foodList = avaiFoodManagementDTO.getAvailableFoodItemList();

		for (int i = 0; i < foodList.size(); i++) {
			for (int k = i + 1; k < foodList.size(); k++) {

				if (foodList.get(i).getFoodName().equalsIgnoreCase(foodList.get(k).getFoodName())) {

					isDuplicate = true;

				}
			}
		}

		return isDuplicate;

	}

	@Override
	public boolean checkMandatoryField(AvaiFoodManagementDTO avaiFoodManagementDTO) {

		boolean isFalse = false;
		List<AvaiFoodItemDTO> foodList = avaiFoodManagementDTO.getAvailableFoodItemList();

		for (AvaiFoodItemDTO foodItem : foodList) {

			if (foodItem.getFoodName().equals("string") || foodItem.getFoodName().trim().isEmpty()
					|| foodItem.getFoodName() == null) {

				isFalse = true;

			}

		}

		return isFalse;
	}

}
