package com.sicmsb.foodinventory.dto;

import java.util.Date;
import java.util.List;

import com.sicmsb.foodinventory.model.Food;

import io.swagger.annotations.ApiModelProperty;

public class VotingFoodOptionsDTO {


	@ApiModelProperty(value = "The starting date for the voting poll", required = true)
	private String votingPeriodStartDate;

	@ApiModelProperty(value = "The ending date for the voting poll", required = true)
	private String votingPeriodEndDate;
	
	@ApiModelProperty(value = "The food available period (start date)", required = true)
	private String foodAvailableStartDate;

	@ApiModelProperty(value = "The food available period (end date)", required = true)
	private String foodAvailableEndDate;

	@ApiModelProperty(value = "List of Available Food to Vote", required = true)
	private List<String> listOfAvailableFoodToVote;


	public String getVotingPeriodStartDate() {
		return votingPeriodStartDate;
	}

	public void setVotingPeriodStartDate(String startDate) {
		this.votingPeriodStartDate = startDate;
	}

	public String getVotingPeriodEndDate() {
		return votingPeriodEndDate;
	}

	public void setVotingPeriodEndDate(String endDate) {
		this.votingPeriodEndDate = endDate;
	}

	public List<String> getListOfAvailableFoodToVote() {
		return listOfAvailableFoodToVote;
	}
	
	public void setListOfAvailableFoodToVote(List<String> listOfAvailableFoodToVote) {
		this.listOfAvailableFoodToVote = listOfAvailableFoodToVote;
	}

	public String getFoodAvailableStartDate() {
		return foodAvailableStartDate;
	}

	public void setFoodAvailableStartDate(String foodAvailableStartDate) {
		this.foodAvailableStartDate = foodAvailableStartDate;
	}

	public String getFoodAvailableEndDate() {
		return foodAvailableEndDate;
	}

	public void setFoodAvailableEndDate(String foodAvailableEndDate) {
		this.foodAvailableEndDate = foodAvailableEndDate;
	}


	
	

}
