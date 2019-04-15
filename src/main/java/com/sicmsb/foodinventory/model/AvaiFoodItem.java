package com.sicmsb.foodinventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVAI_FOOD_ITEM")
public class AvaiFoodItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "avai_food_management_id", nullable = false)
	private Long avaiFoodMgntId;

	@Column(name = "food_name", length = 100, nullable = false)
	private String foodName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAvaiFoodMgntId() {
		return avaiFoodMgntId;
	}

	public void setAvaiFoodMgntId(Long avaiFoodMgntId) {
		this.avaiFoodMgntId = avaiFoodMgntId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

}
