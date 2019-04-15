package com.sicmsb.foodinventory.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class VotingPollMgntDTO {

	@ApiModelProperty(value = "The unique identifier of the given voting poll", readOnly = true)
	private Long id;

	@ApiModelProperty(value = "Description of the start date", required = true)
	private Date startDate;

	@ApiModelProperty(value = "Description of the end date", required = true)
	private Date endDate;

	@ApiModelProperty(value = "Description", required = true)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
