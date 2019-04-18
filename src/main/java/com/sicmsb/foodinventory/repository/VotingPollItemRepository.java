package com.sicmsb.foodinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sicmsb.foodinventory.model.VotingPollItem;


@Repository
public interface VotingPollItemRepository extends JpaRepository<VotingPollItem, Long> {
	
	public List<VotingPollItem> findByVotingPollManagementId (Long id);
}
