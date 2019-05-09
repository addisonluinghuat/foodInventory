package com.sicmsb.foodinventory.service;

import java.util.Date;

import com.sicmsb.foodinventory.dto.VotingFoodOptionsDTO;
import com.sicmsb.foodinventory.dto.VotingPollMgntDTO;
import com.sicmsb.foodinventory.model.VotingPollMgnt;

public interface VotingPollMgntService {

	public void createVotingNewVotingPoll(VotingPollMgntDTO votingPollMgntDTO);

	public VotingPollMgnt retrieveCurrentVotingPoll();

	public VotingFoodOptionsDTO retrieveAvailableFoodVoteOptions(VotingPollMgnt currentVotingPoll);

	public VotingFoodOptionsDTO availableFoodVoteOptionsAPIService();

	public boolean duplicateVotePeriodExist(Date voteStartDate, Date voteEndDate);

	public boolean duplicateAvailablePeriodExist(Date foodAvailableStartDate, Date foodAvailableEndDate);

}
