package com.sicmsb.foodinventory.dto;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class VoteFoodDTO {

	@ApiModelProperty(value = "The unique identifier of the given voting food", readOnly = true)
	private Long employeeId;
	
	@ApiModelProperty(value = "Voting food item list", required = true)
	private List<VotingPollItemDTO> votingFoodItemList;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public List<VotingPollItemDTO> getVotingFoodItemList() {
		return votingFoodItemList;
	}

	public void setVotingFoodItemList(List<VotingPollItemDTO> votingFoodItemList) {
		this.votingFoodItemList = votingFoodItemList;
	}
}
