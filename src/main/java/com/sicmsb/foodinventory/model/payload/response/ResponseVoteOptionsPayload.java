package com.sicmsb.foodinventory.model.payload.response;

import java.util.Date;

import com.sicmsb.foodinventory.dto.VotingFoodOptionsDTO;

public class ResponseVoteOptionsPayload {
	

	private VotingFoodOptionsDTO foodVoteOptionsList;

	public VotingFoodOptionsDTO getFoodVoteOptionsList() {
		return foodVoteOptionsList;
	}

	public void setFoodVoteOptionsList(VotingFoodOptionsDTO foodVoteOptionsList) {
		this.foodVoteOptionsList = foodVoteOptionsList;
	}
	
	
}
