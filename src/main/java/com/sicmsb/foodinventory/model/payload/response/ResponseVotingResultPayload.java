package com.sicmsb.foodinventory.model.payload.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sicmsb.foodinventory.dto.VotingPollItemDTO;
import com.sicmsb.foodinventory.model.VotingPollItem;

public class ResponseVotingResultPayload {
	private Long votingManagementId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date voteStartDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date voteEndDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date foodAvaiStartDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date foodAvaiEndDate;
	
	private String description;
	
	private List<VotingPollItemDTO> votingPollItemList;

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

	public List<VotingPollItemDTO> getVotingPollItemList() {
		return votingPollItemList;
	}

	public void setVotingPollItemList(List<VotingPollItemDTO> votingPollItemList) {
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