package com.sicmsb.foodinventory.service;

import java.util.List;
import java.util.Optional;

import com.sicmsb.foodinventory.dto.VotingPollItemDTO;
import com.sicmsb.foodinventory.exception.BaseException;
import com.sicmsb.foodinventory.model.EmployeeInfo;
import com.sicmsb.foodinventory.model.VotingPollItem;
import com.sicmsb.foodinventory.model.VotingPollMgnt;
import com.sicmsb.foodinventory.model.payload.response.ResponseVotingResultPayload;

public interface VotingFoodService {

	void UpdateVoteResult(List<VotingPollItem> votingPollItemList, Long employeeId) throws BaseException;

	Optional<EmployeeInfo> validateUser(Long employeeId) throws BaseException;

	VotingPollMgnt validateVotingPoll() throws BaseException;

	List<VotingPollItem> validateVoteItem(Long currentVotingPollId, List<VotingPollItemDTO> foodList) throws BaseException;

	void validateDuplicateVote(Long employeeId, List<VotingPollItem> votingPollItemList) throws BaseException;
	
	VotingPollMgnt getVotingPollManagement();
	
	List<VotingPollItem> getVotingItem(Long id);
	
	ResponseVotingResultPayload mappedIntoVoteResultPayload(VotingPollMgnt votingPollManagement, List<VotingPollItem> votingPollItemList);
}
