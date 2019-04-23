package com.sicmsb.foodinventory.model;

import io.swagger.annotations.ApiModelProperty;

public class FoodVoteOptions {

	@ApiModelProperty(notes = "Food Vote Options")
	private Long id;
	private String name;

	public FoodVoteOptions() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
