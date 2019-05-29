package com.sicmsb.foodinventory.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class VotingPollItemDTO {

	 @ApiModelProperty(value = "The unique identifier of the given voting poll management item", readOnly = false)
	 private Long id;
	 
	 @ApiModelProperty(value = "The voting poll management id", readOnly = false)
	 private Long votingPollManagementId;
	 
	 @ApiModelProperty(value = "Description of the food name", required = true)
	 private String foodName;
	 
	 @ApiModelProperty(value = "Total Vote", readOnly = false)
	 private int totalVote;

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public Long getVotingPollManagementId() {
		return votingPollManagementId;
	}

	public void setVotingPollManagementId(Long votingPollManagementId) {
		this.votingPollManagementId = votingPollManagementId;
	}

	public String getFoodName() {
		return foodName;
	 }

	 public void setFoodName(String foodName) {
		this.foodName = foodName;
	 }

	public int getTotalVote() {
		return totalVote;
	}

	public void setTotalVote(int totalVote) {
		this.totalVote = totalVote;
	}

}
