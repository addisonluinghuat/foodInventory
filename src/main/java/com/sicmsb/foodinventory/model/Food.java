package com.sicmsb.foodinventory.model;

import io.swagger.annotations.ApiModelProperty;

public class Food {

	@ApiModelProperty(notes = "Food name")
	private String name;
	private String description;

	public Food() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
