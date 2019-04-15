package com.sicmsb.foodinventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sicmsb.foodinventory.model.EmployeeInfo;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Long> {

	public Optional<EmployeeInfo> findById(Long id);
}
