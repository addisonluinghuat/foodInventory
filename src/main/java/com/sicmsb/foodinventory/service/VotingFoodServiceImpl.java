package com.sicmsb.foodinventory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.dto.VotingPollItemDTO;
import com.sicmsb.foodinventory.exception.BaseException;
import com.sicmsb.foodinventory.model.EmployeeInfo;
import com.sicmsb.foodinventory.model.VotingPollItem;
import com.sicmsb.foodinventory.model.VotingPollMgnt;
import com.sicmsb.foodinventory.model.VotingTransaction;
import com.sicmsb.foodinventory.repository.VotingPollItemRepository;
import com.sicmsb.foodinventory.repository.VotingTransactionRepository;

@Transactional
@Service
public class VotingFoodServiceImpl implements VotingFoodService {

	@Inject
	private EmployeeInfoService employeeInfoService;

	@Inject
	private VotingPollMgntService votingPollMgntService;

	@Inject
	private VotingPollItemRepository votingPollItemRepository;

	@Inject
	private VotingTransactionRepository votingTransactionRepository;

	// validate user exist
	public Optional<EmployeeInfo> validateUser(Long employeeId) throws BaseException {
		final Optional<EmployeeInfo> employee = employeeInfoService.getEmployeeInfoById(employeeId);

		if (!employee.isPresent()) {
			throw new BaseException(100, "User is not exist.");
		}

		return employee;
	}

	// validate voting poll exist
	public VotingPollMgnt validateVotingPoll() throws BaseException {
		final VotingPollMgnt currentVotingPoll = votingPollMgntService.retrieveCurrentVotingPoll();

		if (currentVotingPoll == null) {
			throw new BaseException(101, "Current voting poll is not exist.");
		}

		return currentVotingPoll;
	}

	public List<VotingPollItem> validateVoteItem(Long currentVotingPollId, List<VotingPollItemDTO> foodList)
			throws BaseException {
		List<VotingPollItem> votingPollItemList = new ArrayList<VotingPollItem>();
		for (VotingPollItemDTO foodRequest : foodList) {
			String foodName = foodRequest.getFoodName();
			VotingPollItem votingPollItem = votingPollMgntService.findItemByVotingPollIdAndFoodName(currentVotingPollId,
					foodName);

			if (votingPollItem == null) {
				throw new BaseException(102, "Food does not exist in voting poll item: " + foodName);
			}
			votingPollItemList.add(votingPollItem);
		}
		return votingPollItemList;
	}

	public void validateDuplicateVote(Long employeeId, List<VotingPollItem> votingPollItemList) throws BaseException {
		for (VotingPollItem votingPollItem : votingPollItemList) {
			Long votingPollItemId = votingPollItem.getId();
			VotingTransaction votingTransaction = votingTransactionRepository
					.findByVotingPollItemIdAndCreatedBy(votingPollItemId, employeeId);

			if (votingTransaction != null) {
				throw new BaseException(103, "User has already voted for current poll");
			}
		}
	}

	// insert and update food voting table
	public void UpdateVoteResult(List<VotingPollItem> votingPollItemList, Long employeeId) throws BaseException {
		for (VotingPollItem votingPollItem : votingPollItemList) {
			Long votingPollItemId = votingPollItem.getId();
			updateTotalVote(votingPollItem);
			insertVotingTransaction(votingPollItemId, employeeId);
		}
	}

	// insert vote into voting transaction table
	private void insertVotingTransaction(Long votingPollItemId, Long employeeId) {
		VotingTransaction votingTransaction = new VotingTransaction();
		votingTransaction.setVotingPollItemId(votingPollItemId);
		votingTransaction.setCreatedBy(employeeId);
		votingTransaction.setCreatedDate(new Date());
		votingTransactionRepository.save(votingTransaction);
	}

	private void updateTotalVote(VotingPollItem votingPollItem) {
		int totalVoteOri = votingPollItem.getTotalVote();
		int totalVoteNew = totalVoteOri + 1;
		votingPollItem.setTotalVote(totalVoteNew);
		votingPollItemRepository.save(votingPollItem);
	}
}