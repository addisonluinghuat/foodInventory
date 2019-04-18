package com.sicmsb.foodinventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VOTING_POLL_ITEM")
public class VotingPollItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "voting_poll_management_id", nullable = false)
	private Long votingPollManagementId;

	@Column(name = "food_name", length = 100, nullable = false)
	private String foodName;
	
	@Column(name = "total_vote", nullable = false)
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
