package com.sicmsb.foodinventory.service;

import com.sicmsb.foodinventory.dto.VotingFoodOptionsDTO;
import com.sicmsb.foodinventory.dto.VotingPollMgntDTO;

import com.sicmsb.foodinventory.model.VotingPollMgnt;

public interface VotingPollMgntService {

	public VotingPollMgnt create(VotingPollMgntDTO votingPollMgntDTO);
	
	public VotingPollMgnt retrieveCurrentVotingPoll();
	
	public VotingFoodOptionsDTO retrieveAvailableFoodVoteOptions(VotingPollMgnt currentVotingPoll);
	
	public VotingFoodOptionsDTO availableFoodVoteOptionsAPIService();

}
