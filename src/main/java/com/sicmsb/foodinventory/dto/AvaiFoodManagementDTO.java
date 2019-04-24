package com.sicmsb.foodinventory.dto;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class AvaiFoodManagementDTO {

//	@ApiModelProperty(value = "The unique identifier of the given available food item", readOnly = true)
//	private Long id;

	@ApiModelProperty(value = "Start date of the available food management", required = true)
	private Date startDate;

	@ApiModelProperty(value = "End date of the available food management", required = true)
	private Date endDate;

	@ApiModelProperty(value = "Available food item list", required = true)
	private List<AvaiFoodItemDTO> availableFoodItemList;
	
	public AvaiFoodManagementDTO(Date startDate, Date endDate) {
		super();
		//this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
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
