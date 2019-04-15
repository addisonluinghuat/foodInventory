package com.sicmsb.foodinventory.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.dto.AvaiFoodItemDTO;
import com.sicmsb.foodinventory.repository.AvaiFoodItemRepository;

@Transactional
@Service
public class AvaiFoodItemServiceImpl implements AvaiFoodItemService {

	@Inject
	private AvaiFoodItemRepository avaiFoodItemRepository;

	@Transactional(readOnly = true)
	public List<AvaiFoodItemDTO> getAvaiFoodItem() {
		// new AvaiFoodItemDTO(null, null, null);
		return avaiFoodItemRepository.findAll().stream()
				.map(entity -> new AvaiFoodItemDTO(entity.getId(), entity.getAvaiFoodMgntId(), entity.getFoodName()))
				.collect(Collectors.toList());

	}

}
