package com.sicmsb.foodinventory.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sicmsb.foodinventory.model.Food;
import com.sicmsb.foodinventory.model.FoodVoteOptions;

import io.swagger.annotations.ApiModelProperty;

public class VotingFoodOptionsDTO {


	@ApiModelProperty(value = "The starting date for the voting poll", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date votingPeriodStartDate;

	@ApiModelProperty(value = "The ending date for the voting poll", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date votingPeriodEndDate;
	
	@ApiModelProperty(value = "The food available period (start date)", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date foodAvailableStartDate;

	@ApiModelProperty(value = "The food available period (end date)", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date foodAvailableEndDate;

	@ApiModelProperty(value = "List of Available Food to Vote", required = true)
	private List<FoodVoteOptions> listOfAvailableFoodToVote;


	public Date getVotingPeriodStartDate() {
		return votingPeriodStartDate;
	}

	public void setVotingPeriodStartDate(Date votingPeriodStartDate) {
		this.votingPeriodStartDate = votingPeriodStartDate;
	}

	public Date getVotingPeriodEndDate() {
		return votingPeriodEndDate;
	}

	public void setVotingPeriodEndDate(Date votingPeriodEndDate) {
		this.votingPeriodEndDate = votingPeriodEndDate;
	}

	public List<FoodVoteOptions> getListOfAvailableFoodToVote() {
		return listOfAvailableFoodToVote;
	}
	
	public void setListOfAvailableFoodToVote(List<FoodVoteOptions> listOfAvailableFoodToVote) {
		this.listOfAvailableFoodToVote = listOfAvailableFoodToVote;
	}

	public Date getFoodAvailableStartDate() {
		return foodAvailableStartDate;
	}

	public void setFoodAvailableStartDate(Date foodAvailableStartDate) {
		this.foodAvailableStartDate = foodAvailableStartDate;
	}

	public Date getFoodAvailableEndDate() {
		return foodAvailableEndDate;
	}

	public void setFoodAvailableEndDate(Date foodAvailableEndDate) {
		this.foodAvailableEndDate = foodAvailableEndDate;
	}


	
	

}
