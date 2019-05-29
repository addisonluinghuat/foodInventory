package com.sicmsb.foodinventory.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Objects;

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
import com.sicmsb.foodinventory.dto.VoteFoodDTO;
import com.sicmsb.foodinventory.dto.VotingPollItemDTO;
import com.sicmsb.foodinventory.dto.VotingPollMgntDTO;
import com.sicmsb.foodinventory.exception.BaseException;
import com.sicmsb.foodinventory.model.AvaiFoodManagement;
import com.sicmsb.foodinventory.model.EmployeeInfo;
import com.sicmsb.foodinventory.model.Food;
import com.sicmsb.foodinventory.model.VotingPollItem;
import com.sicmsb.foodinventory.model.VotingPollMgnt;
import com.sicmsb.foodinventory.model.payload.request.Header;
import com.sicmsb.foodinventory.model.payload.response.ResponseBase;
import com.sicmsb.foodinventory.model.payload.response.ResponseCreateFoodPayload;
import com.sicmsb.foodinventory.model.payload.response.ResponseVoteOptionsPayload;
import com.sicmsb.foodinventory.model.payload.response.ResponseVotingPollPayload;
import com.sicmsb.foodinventory.model.payload.response.ResponseVotingResultPayload;
import com.sicmsb.foodinventory.repository.VotingPollMgntRepository;
import com.sicmsb.foodinventory.service.AvaiFoodItemService;
import com.sicmsb.foodinventory.service.AvaiFoodManagementService;
import com.sicmsb.foodinventory.service.EmployeeInfoService;
import com.sicmsb.foodinventory.service.VotingFoodService;
import com.sicmsb.foodinventory.service.VotingPollMgntService;
import com.sicmsb.foodinventory.type.RoleType;
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
	
	@Inject
	private VotingFoodService votingFoodService;

	private static final Logger logger = LoggerFactory.getLogger(FoodController.class);

	@ApiOperation(value = "Create Voting Poll", response = Food.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/food/voting-poll", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> votingPoll(
			@ApiParam("Person information for a new person to be created.") @Valid @RequestBody VotingPollMgntDTO votingPollMgntDTO)
			throws BaseException {
		logger.info("Starting Create Voting Poll");
		Header header = new Header();

		final Long employeeId = votingPollMgntDTO.getEmployeeId();
		final Optional<EmployeeInfo> employee = employeeInfoService.getEmployeeInfoById(employeeId);

		// validate employee is exist and the role must equal to admin
		if (!employee.isPresent() || !(RoleType.ADMIN.getCode().equals(employee.get().getRoleInfo().getRoleDesc()))) {
			throw new BaseException(100, "This employee do not have authority to create voting poll");
		}
		// to check the input vote start date and vote end date is exist in database
		if (votingPollMgntService.duplicateVotePeriodExist(votingPollMgntDTO.getVoteStartDate(),
				votingPollMgntDTO.getVoteEndDate())) {
			throw new BaseException(101, "Duplicate voting period found in dabatase.");
		}
		// to check the input food available start date and food available end date is
		// exist in database
		if (votingPollMgntService.duplicateAvailablePeriodExist(votingPollMgntDTO.getFoodAvailestartDate(),
				votingPollMgntDTO.getFoodAvailableEndDate())) {
			throw new BaseException(102, "Duplicate food available period found in dabatase.");
		}

		if (votingPollMgntDTO.getVoteStartDate().compareTo(votingPollMgntDTO.getVoteEndDate()) > 0) {
			throw new BaseException(103, " vote start date cannot after vote end date");
		}

		if (votingPollMgntDTO.getFoodAvailestartDate().compareTo(votingPollMgntDTO.getFoodAvailableEndDate()) > 0) {
			throw new BaseException(104, " food available start date cannot after food available end date");
		}

		if (votingPollMgntDTO.getVoteEndDate().compareTo(votingPollMgntDTO.getFoodAvailestartDate()) >= 0) {
			throw new BaseException(105, " food available start date must be after vote end date");
		}

		votingPollMgntService.createVotingNewVotingPoll(votingPollMgntDTO);
		ResponseVotingPollPayload responseVotingPollPayload = new ResponseVotingPollPayload();
		ResponseBase<ResponseVotingPollPayload> response = CommonUtil.genResponseBase(header);
		responseVotingPollPayload.setMsg("Voting poll had successfully created");
		response.setPayload(responseVotingPollPayload);
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
	public ResponseEntity<?> vote(
			@ApiParam("Vote food for available period.") @Valid @RequestBody VoteFoodDTO voteFoodDTO)
			throws BaseException {
		logger.info("Starting Vote Desired Food");
		
//		Optional<EmployeeInfo> employee = votingFoodService.validationProcess(voteFoodDTO);
		final Long employeeId = voteFoodDTO.getEmployeeId();
		Optional<EmployeeInfo> employee = votingFoodService.validateUser(employeeId);

		final VotingPollMgnt currentVotingPoll = votingFoodService.validateVotingPoll();

		Long currentVotingPollId = currentVotingPoll.getId();
		List<VotingPollItemDTO> foodList = voteFoodDTO.getVotingFoodItemList();
		List<VotingPollItem> votingPollItemList = votingFoodService.validateVoteItem(currentVotingPollId, foodList);
		votingFoodService.validateDuplicateVote(employeeId, votingPollItemList);
		
//		String employeeName = employee.get().getName();
		
		votingFoodService.UpdateVoteResult(votingPollItemList, employeeId);
		
		Header header = new Header();
		ResponseBase<ResponseVoteOptionsPayload> response = CommonUtil.genResponseBase(header);
		ResponseVoteOptionsPayload responseVoteOptionsPayload = new ResponseVoteOptionsPayload();
		responseVoteOptionsPayload.setFoodVoteOptionsList(votingPollMgntService.availableFoodVoteOptionsAPIService());
		response.setPayload(responseVoteOptionsPayload);
		
		logger.info("Ending Vote Desired Food");
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "View Voting Result", response = Food.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/food/voting-result", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> votingResult() throws BaseException {
		logger.info("Starting View Voting Result");
		
		VotingPollMgnt currentPollManagement = votingFoodService.getVotingPollManagement();
		
		if (Objects.isNull(currentPollManagement)) {
			throw new BaseException(106, "No voting result.");
		}
		
		List<VotingPollItem> currentPollList = votingFoodService.getVotingItem(currentPollManagement.getId());
		
		Header header = new Header();
		ResponseBase<ResponseVotingResultPayload> response = CommonUtil.genResponseBase(header);
		ResponseVotingResultPayload voteResultPayload = new ResponseVotingResultPayload();
		voteResultPayload = votingFoodService.mappedIntoVoteResultPayload(currentPollManagement, currentPollList);
		response.setPayload(voteResultPayload);
		
		logger.info("Ending View Voting Result");
		return ResponseEntity.ok(response);
	}

	// Create Food List API
	@ApiOperation(value = "Create List of Food for current period", response = Food.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 401, message = "Unauthorized") })
	@RequestMapping(value = "/food/list", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createFood(
			@ApiParam("Create food list for current period.") @Valid @RequestBody AvaiFoodManagementDTO avaiFoodManagementDTO)
			throws BaseException {
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
			avaiFoodItemService.createFoodItem(foodItem, avaiFoodManagement);

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
