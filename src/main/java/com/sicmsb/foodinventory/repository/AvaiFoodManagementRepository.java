package com.sicmsb.foodinventory.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sicmsb.foodinventory.model.AvaiFoodManagement;

@Repository
public interface AvaiFoodManagementRepository extends JpaRepository<AvaiFoodManagement, Long> {

	@Query(value = "select * from avai_food_management where ?1 between start_date and end_date", nativeQuery = true)
	public Optional<AvaiFoodManagement> findCurrPerFoodManagement(Date todayDate);

	@Query("from AvaiFoodManagement a where a.startDate = :sDate and a.endDate=:eDate")
	public Optional<AvaiFoodManagement> findByStartDateAndEndDate(Date sDate, Date eDate);
}
