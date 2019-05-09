package com.sicmsb.foodinventory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.dto.VotingFoodOptionsDTO;
import com.sicmsb.foodinventory.dto.VotingPollItemDTO;
import com.sicmsb.foodinventory.dto.VotingPollMgntDTO;
import com.sicmsb.foodinventory.model.FoodVoteOptions;
import com.sicmsb.foodinventory.model.VotingPollItem;
import com.sicmsb.foodinventory.model.VotingPollMgnt;
import com.sicmsb.foodinventory.repository.VotingPollItemRepository;
import com.sicmsb.foodinventory.repository.VotingPollMgntRepository;

@Transactional
@Service
public class VotingPollMgntServiceImpl implements VotingPollMgntService {

	private static final Logger logger = LoggerFactory.getLogger(VotingPollMgntServiceImpl.class);

	@Inject
	private VotingPollMgntRepository votingPollMgntRepository;

	@Inject
	private VotingPollItemRepository votingPollItemRepository;

	private VotingPollMgnt saveVotingPollMgnt(Long id, String description, Date voteStartDate, Date voteEndDate,
			Date foodAvailableStartDate, Date foodAvailableEndDate) {

		VotingPollMgnt votingPollMgnt = new VotingPollMgnt();
		votingPollMgnt.setDescription(description);
		votingPollMgnt.setVoteStartDate(voteStartDate);
		votingPollMgnt.setVoteEndDate(voteEndDate);
		votingPollMgnt.setFoodAvailableStartDate(foodAvailableStartDate);
		votingPollMgnt.setFoodAvailableEndDate(foodAvailableEndDate);
		votingPollMgnt.setCreatedBy(id);
		votingPollMgnt.setCreatedDate(new Date());
		return votingPollMgntRepository.save(votingPollMgnt);
	}

	private void saveVotingPollItem(Long votingPollMgntId, VotingPollItemDTO votingPollItemDTO, Long id) {

		VotingPollItem votingPollItem = new VotingPollItem();
		votingPollItem.setFoodName(votingPollItemDTO.getFoodName());
		votingPollItem.setVotingPollManagementId(votingPollMgntId);
		votingPollItem.setCreatedBy(id);
		votingPollItem.setCreatedDate(new Date());
		votingPollItemRepository.save(votingPollItem);

	}

	@Transactional
	public void createVotingNewVotingPoll(VotingPollMgntDTO votingPollMgntDTO) {

		logger.info("start createVotingNewVotingPoll");
		
		// initialize all variable
		final Long employeeId = votingPollMgntDTO.getEmployeeId();
		final String description = votingPollMgntDTO.getDescription();
		final Date voteStartDate = votingPollMgntDTO.getVoteStartDate();
		final Date voteEndDate = votingPollMgntDTO.getVoteEndDate();
		final Date foodAvailableStartDate = votingPollMgntDTO.getFoodAvailestartDate();
		final Date foodAvailableEndDate = votingPollMgntDTO.getFoodAvailableEndDate();
		final List<VotingPollItemDTO> votingPollItemList = votingPollMgntDTO.getVotingFoodItemList();
		// create new voting poll management
		
		//save voting poll management record
		VotingPollMgnt votingPollMgnt = saveVotingPollMgnt(employeeId, description, voteStartDate, voteEndDate,
				foodAvailableStartDate, foodAvailableEndDate);

		logger.info("votingPollMgnt id : {}", votingPollMgnt.getId());
		// foreach loop to save each fooditem in list to db
		votingPollItemList.forEach(vpItem -> {
			saveVotingPollItem(votingPollMgnt.getId(), vpItem, employeeId);
		});
		
		logger.info("end createVotingNewVotingPoll");
	}

	public VotingPollMgnt retrieveCurrentVotingPoll() {
		return votingPollMgntRepository.findVotingPollForCurrentPeriod(new Date());
	}

	public VotingFoodOptionsDTO retrieveAvailableFoodVoteOptions(VotingPollMgnt currentVotingPoll) {

		VotingFoodOptionsDTO availableFoodVoteOptions = new VotingFoodOptionsDTO();

		List<VotingPollItem> votingFoodOptionsList = votingPollItemRepository
				.findByVotingPollManagementId(currentVotingPoll.getId());
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

	@Transactional(readOnly = true)
	public boolean duplicateVotePeriodExist(Date voteStartDate, Date voteEndDate) {

		boolean isDuplicate = false;

		VotingPollMgnt getDuplicateVoteStartDate = votingPollMgntRepository
				.getBetweenVoteDate(voteStartDate);
		VotingPollMgnt getDuplicateVoteEndDate = votingPollMgntRepository
				.getBetweenVoteDate(voteEndDate);

		if (!(Objects.isNull(getDuplicateVoteStartDate) && Objects.isNull(getDuplicateVoteEndDate))) {
			isDuplicate = true;
		}

		return isDuplicate;
	}

	@Transactional(readOnly = true)
	public boolean duplicateAvailablePeriodExist(Date foodAvailableStartDate, Date foodAvailableEndDate) {

		boolean isDuplicate = false;

		VotingPollMgnt getDuplicateAvailableStartDate = votingPollMgntRepository
				.getBetweenFoodAvailableDate(foodAvailableStartDate);
		VotingPollMgnt getDuplicateAvailableEndDate = votingPollMgntRepository
				.getBetweenFoodAvailableDate(foodAvailableEndDate);

		if (!(Objects.isNull(getDuplicateAvailableStartDate) && Objects.isNull(getDuplicateAvailableEndDate))) {
			isDuplicate = true;
		}

		return isDuplicate;
	}
}
