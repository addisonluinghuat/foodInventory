package com.sicmsb.foodinventory.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class AvaiFoodManagementDTO {

	// @ApiModelProperty(value = "The unique identifier of the given available food
	// item", readOnly = true)
	// private Long id;

	@ApiModelProperty(value = "The unique identifier of the given voting poll", readOnly = true)
	private Long employeeId;

	@ApiModelProperty(value = "Start date of the available food management", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;

	@ApiModelProperty(value = "End date of the available food management", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate;

	@ApiModelProperty(value = "Available food item list", required = true)
	private List<AvaiFoodItemDTO> availableFoodItemList;

	public AvaiFoodManagementDTO() {
		super();

	}

	public AvaiFoodManagementDTO(Long employeeId, Date startDate, Date endDate) {
		super();
		// this.id = id;
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public List<AvaiFoodItemDTO> getAvailableFoodItemList() {
		return availableFoodItemList;
	}

	public void setAvailableFoodItemList(List<AvaiFoodItemDTO> availableFoodItemList) {
		this.availableFoodItemList = availableFoodItemList;
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

}
