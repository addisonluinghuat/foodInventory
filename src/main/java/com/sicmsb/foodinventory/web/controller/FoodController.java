package com.sicmsb.foodinventory.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sicmsb.foodinventory.dto.AvaiFoodManagementDTO;
import com.sicmsb.foodinventory.dto.VotingPollMgntDTO;
import com.sicmsb.foodinventory.model.AvaiFoodManagement;
import com.sicmsb.foodinventory.model.Food;
import com.sicmsb.foodinventory.model.payload.request.Header;
import com.sicmsb.foodinventory.model.payload.response.ResponseBase;
import com.sicmsb.foodinventory.model.payload.response.ResponseCreateFoodPayload;
import com.sicmsb.foodinventory.model.payload.response.ResponseVoteOptionsPayload;
import com.sicmsb.foodinventory.model.payload.response.ResponseVotingPollPayload;
import com.sicmsb.foodinventory.service.AvaiFoodItemService;
import com.sicmsb.foodinventory.service.AvaiFoodManagementService;
import com.sicmsb.foodinventory.service.EmployeeInfoService;
import com.sicmsb.foodinventory.service.VotingPollMgntService;
import com.sicmsb.foodinventory.util.CommonUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FoodController {

	// @Inject
	// private FoodService foodService;

	@Inject
	private AvaiFoodItemService avaiFoodItemService;

	@Inject
	private VotingPollMgntService votingPollMgntService;

	@Inject
	private EmployeeInfoService employeeInfoService;

	@Inject
	private AvaiFoodManagementService avaiFoodManagementService;

	private static final Logger logger = LoggerFactory.getLogger(FoodController.class);

	@ApiOperation(value = "Create Voting Poll", response = Food.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/food/voting-poll", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> votingPoll(
			@ApiParam("Person information for a new person to be created.") @Valid @RequestBody VotingPollMgntDTO votingPollMgntDTO) {
		logger.info("Starting Create Voting Poll");
		Header header = new Header();
		votingPollMgntService.create(votingPollMgntDTO);
		ResponseBase<ResponseVotingPollPayload> response = CommonUtil.genResponseBase(header);
		// ResponseVotingPollPayload responseVotingPollPayload = new
		// ResponseVotingPollPayload();
		// response.setPayload(responseVotingPollPayload);
		logger.info("Ending Create Voting Poll");
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "View Options for food voting", response = ResponseVoteOptionsPayload.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = ResponseBase.class),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/food/vote/options", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> voteOptions() {
		logger.info("Starting View Options for food voting");

		Header header = new Header();
		ResponseBase<ResponseVoteOptionsPayload> response = CommonUtil.genResponseBase(header);
		ResponseVoteOptionsPayload responseVoteOptionsPayload = new ResponseVoteOptionsPayload();
		responseVoteOptionsPayload.setFoodVoteOptionsList(votingPollMgntService.availableFoodVoteOptionsAPIService());
		response.setPayload(responseVoteOptionsPayload);

		logger.info("Ending View Options for food voting");
		return ResponseEntity.ok(response);

	}

	@ApiOperation(value = "Vote Desired Food", response = Food.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/food/vote", method = RequestMethod.POST, produces = "application/json")
	public List<Food> vote() {
		logger.info("Starting Vote Desired Food");
		List<Food> foodList = new ArrayList<>();

		logger.info("Ending Vote Desired Food");
		return foodList;
	}

	@ApiOperation(value = "View Voting Result", response = Food.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/food/voting-result", method = RequestMethod.GET, produces = "application/json")
	public List<Food> votingResult() {
		logger.info("Starting View Voting Result");
		List<Food> foodList = new ArrayList<>();
		logger.info("Ending View Voting Result");
		return foodList;
	}

	// Create Food List API
	@ApiOperation(value = "Create List of Food for current period", response = Food.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/food/list", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createFood(
			@ApiParam("Create food list for current period.") @Valid @RequestBody AvaiFoodManagementDTO avaiFoodManagementDTO) {
		logger.info("Starting Create Food List");

		// Set payload header
		Header header = new Header();

		// set avaifoodManagement information in avaiFoodManagement object
		AvaiFoodManagement avaiFoodManagement = avaiFoodManagementService.createFoodManagement(avaiFoodManagementDTO);

		// avaiFoodItemService.createFoodManagement(avaiFoodManagementDTO.getAvailableFoodItemList());
		// List<AvaiFoodItemDTO> listOfAvailableFoodToVote = new ArrayList<>();

		// Include available food item information inside avaiFoodManagement
		// food Item in for each loop represent each item inside the available food item
		// list
		avaiFoodManagementDTO.getAvailableFoodItemList().forEach(foodItem -> {

			// get avaiFoodManagement id from avaiFoodManagement table and set to
			// avaiFoodItem table avaiFoodManagement id (foreign key)
			// foodItem.setAvaiFoodManagementId(avaiFoodManagement.getId());

			// Set food item and save to avai food item table
			avaiFoodItemService.createFoodItem(foodItem);

		});

		// response payload setting
		ResponseBase<ResponseCreateFoodPayload> response = CommonUtil.genResponseBase(header);

		logger.info("Ending Create food list for current period");

		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "View List of Food for current period", response = AvaiFoodManagementDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/food/view-list", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AvaiFoodManagementDTO> getCurrPerFoodList() {
		logger.info("Starting View List of Food for current period");
		AvaiFoodManagementDTO avaiFoodManagementDTO = null;
		try {
			avaiFoodManagementDTO = avaiFoodManagementService.getCurrPerFoodManagement();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		logger.info("Ending View List of Food for current period");
		return ResponseEntity.ok(avaiFoodManagementDTO);
	}
}
