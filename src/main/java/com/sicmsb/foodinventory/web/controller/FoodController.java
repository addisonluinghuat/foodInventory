package com.sicmsb.foodinventory.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sicmsb.foodinventory.model.Food;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FoodController {

	@ApiOperation(value = "Get a list of food", response = Food.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Food> getFoodList() {
		List<Food> foodList = new ArrayList<>();
		Food food = new Food();
		food.setName("Food 1");
		food.setDescription("Food description ");
		foodList.add(food);
		return foodList;
	}
}
