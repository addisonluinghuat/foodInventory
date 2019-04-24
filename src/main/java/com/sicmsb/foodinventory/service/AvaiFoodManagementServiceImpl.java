package com.sicmsb.foodinventory.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.dto.AvaiFoodItemDTO;
import com.sicmsb.foodinventory.dto.AvaiFoodManagementDTO;
import com.sicmsb.foodinventory.model.AvaiFoodManagement;
import com.sicmsb.foodinventory.model.VotingPollMgnt;
import com.sicmsb.foodinventory.repository.AvaiFoodItemRepository;
import com.sicmsb.foodinventory.repository.AvaiFoodManagementRepository;
import com.sicmsb.foodinventory.type.RoleType;

@Transactional
@Service
public class AvaiFoodManagementServiceImpl implements AvaiFoodManagementService {

	@Inject
	private AvaiFoodManagementRepository avaiFoodManagementRepository;

	@Override
	public AvaiFoodManagement createFoodManagement(AvaiFoodManagementDTO avaiFoodManagementDTO) {
		
		//get data from avaiFoodManagement DTO (payload) to avaiFoodManagement model (repository - save to avaiFoodManagementDB)
		AvaiFoodManagement avaiFoodMgnt = new AvaiFoodManagement();
		avaiFoodMgnt.setStartDate(avaiFoodManagementDTO.getStartDate());
		avaiFoodMgnt.setEndDate(avaiFoodManagementDTO.getEndDate());
		avaiFoodMgnt.setCreatedBy("1");
		avaiFoodMgnt.setCreatedDate(new Date());
		
		return avaiFoodManagementRepository.save(avaiFoodMgnt);
		
	}

}
