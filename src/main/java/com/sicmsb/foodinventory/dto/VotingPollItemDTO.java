package com.sicmsb.foodinventory.dto;

import io.swagger.annotations.ApiModelProperty;

public class VotingPollItemDTO {

	// @ApiModelProperty(value = "The unique identifier of the given voting poll
	// management item", readOnly = true)
	// private Long id;

	// @ApiModelProperty(value = "The unique identifier of the given available food
	// management", readOnly = true)
	// private Long avaiFoodManagementId;

	@ApiModelProperty(value = "Description of the food name", required = true)
	private String foodName;

	// public VotingPollItemDTO(Long id, String foodName) {
	// super();
	// this.id = id;
	// this.avaiFoodManagementId = avaiFoodManagementId;
	// this.foodName = foodName;
	// }

	// public Long getId() {
	// return id;
	// }

	// public void setId(Long id) {
	// this.id = id;
	// }

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

}
