package com.sicmsb.foodinventory.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicmsb.foodinventory.dto.VotingPollMgntDTO;
import com.sicmsb.foodinventory.model.VotingPollMgnt;
import com.sicmsb.foodinventory.repository.VotingPollMgntRepository;
import com.sicmsb.foodinventory.type.RoleType;

@Transactional
@Service
public class VotingPollMgntServiceImpl implements VotingPollMgntService {

	@Inject
	private VotingPollMgntRepository votingPollMgntRepository;

	@Override
	public VotingPollMgnt create(VotingPollMgntDTO votingPollMgntDTO) {
		VotingPollMgnt votingPollMgnt = new VotingPollMgnt();
		votingPollMgnt.setDescription(votingPollMgntDTO.getDescription());
		votingPollMgnt.setVoteStartDate(votingPollMgntDTO.getStartDate());
		votingPollMgnt.setVoteEndDate(votingPollMgntDTO.getEndDate());
		votingPollMgnt.setCreatedBy(RoleType.ADMIN.getDescription());
		votingPollMgnt.setCreatedDate(new Date());
		return votingPollMgntRepository.save(votingPollMgnt);
	}

}
