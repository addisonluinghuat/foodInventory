package com.sicmsb.foodinventory.model.payload.response;

import java.util.List;

import com.sicmsb.foodinventory.dto.AvaiFoodItemDTO;

public class ResponseVoteOptionsPayload {

	private List<AvaiFoodItemDTO> foodList;

	public List<AvaiFoodItemDTO> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<AvaiFoodItemDTO> foodList) {
		this.foodList = foodList;
	}

}
