package com.sicmsb.foodinventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sicmsb.foodinventory.model.AvaiFoodItem;
import com.sicmsb.foodinventory.model.AvaiFoodManagement;

@Repository
public interface AvaiFoodManagementRepository extends JpaRepository<AvaiFoodManagement, Long> {

	//public Optional<AvaiFoodItem> findById(Long id);
}
