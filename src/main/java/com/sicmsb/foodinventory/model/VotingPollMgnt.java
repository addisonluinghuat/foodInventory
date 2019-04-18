package com.sicmsb.foodinventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "VOTING_POLL_MANAGEMENT")
public class VotingPollMgnt implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "description", length = 200, nullable = false)
	private String description;

	@Column(name = "vote_start_date")
	private Date voteStartDate;

	@Column(name = "vote_end_date")
	private Date voteEndDate;

	@Column(name = "food_avai_start_date")
	private Date foodAvailableStartDate;

	@Column(name = "food_avai_end_date")
	private Date foodAvailableEndDate;
	
	@Version
	@Column(name = "version", nullable = false)
	private Integer version;

	@Column(name = "created_by", length = 200, nullable = false, updatable = false)
	@CreatedBy
	private String createdBy;

	@Column(name = "created_date", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate = new Date();

	@Column(name = "last_modified_by", length = 200)
	@LastModifiedBy
	private String lastModifiedBy;

	@Column(name = "last_modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
