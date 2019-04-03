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
	
	//TODO - implement the food service to retrieve data from database
	//@Inject
	//private FoodService foodService;
	

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
	
	@ApiOperation(value = "Get a list of food for current period", response = Food.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/currFoodList", method = RequestMethod.GET, produces = "application/json")
	public List<Food> getCurrPerFoodList() {
		List<Food> foodList = new ArrayList<>();
		//Since we dont have food service yet
		//I will just comment out all my implementation to avoid compilation error
		//Date currTime = new Date();
		//return foodService.getCurrPerFoodList(currTime);
		//The logic will be like this
		//We will find the food list based on the current time 
		//If the current time is in between one of the period from database
		//Get all the food details between that period and return it to the client side
		
		return foodList;
	}
}
