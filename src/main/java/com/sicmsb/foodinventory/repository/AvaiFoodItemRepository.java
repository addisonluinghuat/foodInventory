package com.sicmsb.foodinventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sicmsb.foodinventory.model.AvaiFoodItem;

@Repository
public interface AvaiFoodItemRepository extends JpaRepository<AvaiFoodItem, Long> {

	public Optional<AvaiFoodItem> findById(Long id);
}
