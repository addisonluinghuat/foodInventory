package com.sicmsb.foodinventory.model.payload.response;

import java.util.Date;
import java.util.List;

import com.sicmsb.foodinventory.model.VotingPollItem;

public class ResponseVotingResultPayload {
	private Long votingManagementId;
	
	private Date voteStartDate;
	
	private Date voteEndDate;
	
	private Date foodAvaiStartDate;
	
	private Date foodAvaiEndDate;
	
	private String description;
	
	private List<VotingPollItem> votingPollItemList;

	public Long getVotingManagementId() {
		return votingManagementId;
	}

	public void setVotingManagementId(Long votingManagementId) {
		this.votingManagementId = votingManagementId;
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

	public Date getFoodAvaiStartDate() {
		return foodAvaiStartDate;
	}

	public void setFoodAvaiStartDate(Date foodAvaiStartDate) {
		this.foodAvaiStartDate = foodAvaiStartDate;
	}

	public Date getFoodAvaiEndDate() {
		return foodAvaiEndDate;
	}

	public void setFoodAvaiEndDate(Date foodAvaiEndDate) {
		this.foodAvaiEndDate = foodAvaiEndDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<VotingPollItem> getVotingPollItemList() {
		return votingPollItemList;
	}

	public void setVotingPollItemList(List<VotingPollItem> votingPollItemList) {
		this.votingPollItemList = votingPollItemList;
	}

	@Override
	public String toString() {
		return "ResponseVotingResultPayload [votingManagementId=" + votingManagementId + ", voteStartDate="
				+ voteStartDate + ", voteEndDate=" + voteEndDate + ", foodAvaiStartDate=" + foodAvaiStartDate
				+ ", foodAvaiEndDate=" + foodAvaiEndDate + ", description=" + description + ", votingPollItemList="
				+ votingPollItemList + "]";
	} 
	
}