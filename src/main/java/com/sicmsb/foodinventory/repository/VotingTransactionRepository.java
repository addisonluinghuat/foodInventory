package com.sicmsb.foodinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sicmsb.foodinventory.model.VotingTransaction;

@Repository
public interface VotingTransactionRepository extends JpaRepository<VotingTransaction, Long> {

	public VotingTransaction findByVotingPollItemIdAndCreatedBy(Long votingPollItemId, Long employeeId);
}
