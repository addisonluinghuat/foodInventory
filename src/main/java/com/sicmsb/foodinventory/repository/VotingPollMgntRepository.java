package com.sicmsb.foodinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sicmsb.foodinventory.model.VotingPollMgnt;

@Repository
public interface VotingPollMgntRepository extends JpaRepository<VotingPollMgnt, Long> {

}
