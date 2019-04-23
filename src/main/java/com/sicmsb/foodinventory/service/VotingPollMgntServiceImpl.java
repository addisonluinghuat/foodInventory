package com.sicmsb.foodinventory.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.dto.VotingFoodOptionsDTO;
import com.sicmsb.foodinventory.dto.VotingPollMgntDTO;
import com.sicmsb.foodinventory.model.VotingPollMgnt;
import com.sicmsb.foodinventory.model.Food;
import com.sicmsb.foodinventory.model.FoodVoteOptions;
import com.sicmsb.foodinventory.model.VotingPollItem;
import com.sicmsb.foodinventory.repository.VotingPollItemRepository;
import com.sicmsb.foodinventory.repository.VotingPollMgntRepository;
import com.sicmsb.foodinventory.type.RoleType;
import com.sicmsb.foodinventory.util.DateUtil;

@Transactional
@Service
public class VotingPollMgntServiceImpl implements VotingPollMgntService {
	
	private static final Logger logger = LoggerFactory.getLogger(VotingPollMgntServiceImpl.class);

	@Inject
	private VotingPollMgntRepository votingPollMgntRepository;
	
	@Inject
	private VotingPollItemRepository votingPollItemRepository;

	@Override
	public VotingPollMgnt create(VotingPollMgntDTO votingPollMgntDTO) {
		VotingPollMgnt votingPollMgnt = new VotingPollMgnt();
		votingPollMgnt.setDescription(votingPollMgntDTO.getDescription());
		votingPollMgnt.setVoteStartDate(votingPollMgntDTO.getStartDate());
		votingPollMgnt.setVoteEndDate(votingPollMgntDTO.getEndDate());
		votingPollMgnt.setCreatedBy(RoleType.ADMIN.getDescription());
		votingPollMgnt.setCreatedDate(new Date());
		return votingPollMgntRepository.save(votingPollMgnt);
	}
	
	public VotingPollMgnt retrieveCurrentVotingPoll() {
		return votingPollMgntRepository.findVotingPollForCurrentPeriod(new Date());
	}
	
	public VotingFoodOptionsDTO retrieveAvailableFoodVoteOptions(VotingPollMgnt currentVotingPoll) {
		
		VotingFoodOptionsDTO availableFoodVoteOptions = new VotingFoodOptionsDTO();
		
		List<VotingPollItem> votingFoodOptionsList = votingPollItemRepository.findByVotingPollManagementId(currentVotingPoll.getId());
		List<FoodVoteOptions> foodNameList = new ArrayList<>();
		
		for (VotingPollItem foodList : votingFoodOptionsList) {
			FoodVoteOptions foodOption = new FoodVoteOptions();
			foodOption.setId(foodList.getId());
			foodOption.setName(foodList.getFoodName());
			foodNameList.add(foodOption);
		}
		

		availableFoodVoteOptions.setListOfAvailableFoodToVote(foodNameList);
		availableFoodVoteOptions.setVotingPeriodStartDate(currentVotingPoll.getVoteStartDate());
		availableFoodVoteOptions.setVotingPeriodEndDate(currentVotingPoll.getVoteEndDate());
		availableFoodVoteOptions.setFoodAvailableStartDate(currentVotingPoll.getFoodAvailableStartDate());
		availableFoodVoteOptions.setFoodAvailableEndDate(currentVotingPoll.getFoodAvailableEndDate());
		return availableFoodVoteOptions;

	}

	public VotingFoodOptionsDTO availableFoodVoteOptionsAPIService() {
	VotingPollMgnt currentVotingPoll = retrieveCurrentVotingPoll();
	return retrieveAvailableFoodVoteOptions(currentVotingPoll);
	}
}
