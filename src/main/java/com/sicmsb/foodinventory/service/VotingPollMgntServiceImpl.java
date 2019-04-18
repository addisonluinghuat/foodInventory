package com.sicmsb.foodinventory.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.dto.VotingFoodOptionsDTO;
import com.sicmsb.foodinventory.dto.VotingPollMgntDTO;
import com.sicmsb.foodinventory.model.VotingPollMgnt;
import com.sicmsb.foodinventory.model.VotingPollItem;
import com.sicmsb.foodinventory.repository.VotingPollItemRepository;
import com.sicmsb.foodinventory.repository.VotingPollMgntRepository;
import com.sicmsb.foodinventory.type.RoleType;
import com.sicmsb.foodinventory.util.DateUtil;

@Transactional
@Service
public class VotingPollMgntServiceImpl implements VotingPollMgntService {

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
		List<String> foodNameList = new ArrayList<>();
		
		for (VotingPollItem foodList : votingFoodOptionsList) {
			foodNameList.add(foodList.getFoodName());
		}
		

		availableFoodVoteOptions.setListOfAvailableFoodToVote(foodNameList);
		availableFoodVoteOptions.setVotingPeriodStartDate(DateUtil.formatDate(currentVotingPoll.getVoteStartDate()));
		availableFoodVoteOptions.setVotingPeriodEndDate(DateUtil.formatDate(currentVotingPoll.getVoteEndDate()));
		availableFoodVoteOptions.setFoodAvailableStartDate(DateUtil.formatDate(currentVotingPoll.getFoodAvailableStartDate()));
		availableFoodVoteOptions.setFoodAvailableEndDate(DateUtil.formatDate(currentVotingPoll.getFoodAvailableEndDate()));
		return availableFoodVoteOptions;

	}

	public VotingFoodOptionsDTO availableFoodVoteOptionsAPIService() {
	VotingPollMgnt currentVotingPoll = retrieveCurrentVotingPoll();
	return retrieveAvailableFoodVoteOptions(currentVotingPoll);
	}
}
