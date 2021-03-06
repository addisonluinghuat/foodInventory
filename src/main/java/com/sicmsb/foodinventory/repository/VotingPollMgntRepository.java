package com.sicmsb.foodinventory.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sicmsb.foodinventory.model.VotingPollMgnt;

@Repository
public interface VotingPollMgntRepository extends JpaRepository<VotingPollMgnt, Long> {

	@Query(value = "select vpm.* from voting_poll_management vpm where ?1 between vpm.vote_start_date and vpm.vote_end_date", nativeQuery = true)
	public VotingPollMgnt findVotingPollForCurrentPeriod(Date todayDate);

	@Query("from VotingPollMgnt a where :voteDate between a.voteStartDate and a.voteEndDate")
	public VotingPollMgnt getBetweenVoteDate(@Param("voteDate") Date voteDate);

	@Query("from VotingPollMgnt a where :availableDate between a.foodAvailableStartDate and a.foodAvailableEndDate")
	public VotingPollMgnt getBetweenFoodAvailableDate(@Param("availableDate") Date foodAvailableDate);

}
