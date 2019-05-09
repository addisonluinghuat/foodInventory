package com.sicmsb.foodinventory.dto;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class VotingPollMgntDTO {

	@ApiModelProperty(value = "The unique identifier of the given voting poll", readOnly = true)
	private Long employeeId;

	@ApiModelProperty(value = "Description of the vote start date", required = true)
	private Date voteStartDate;

	@ApiModelProperty(value = "Description of the vote end date", required = true)
	private Date voteEndDate;

	@ApiModelProperty(value = "Description of the food available start date", required = true)
	private Date foodAvailestartDate;

	@ApiModelProperty(value = "Description of the food available end date", required = true)
	private Date foodAvailableEndDate;

	@ApiModelProperty(value = "Description", required = true)
	private String description;

	@ApiModelProperty(value = "Voting food item list", required = true)
	private List<VotingPollItemDTO> votingFoodItemList;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<VotingPollItemDTO> getVotingFoodItemList() {
		return votingFoodItemList;
	}

	public void setVotingFoodItemList(List<VotingPollItemDTO> votingFoodItemList) {
		this.votingFoodItemList = votingFoodItemList;
	}

	public Date getVoteStartDate() {
		return voteStartDate;
	}

	public void setVoteStartDate(Date voteStartDate) {
		this.voteStartDate = voteStartDate;
	}

	public Date getVoteEndDate() {
		return voteEndDate;
	}

	public void setVoteEndDate(Date voteEndDate) {
		this.voteEndDate = voteEndDate;
	}

	public Date getFoodAvailestartDate() {
		return foodAvailestartDate;
	}

	public void setFoodAvailestartDate(Date foodAvailestartDate) {
		this.foodAvailestartDate = foodAvailestartDate;
	}

	public Date getFoodAvailableEndDate() {
		return foodAvailableEndDate;
	}

	public void setFoodAvailableEndDate(Date foodAvailableEndDate) {
		this.foodAvailableEndDate = foodAvailableEndDate;
	}

}
