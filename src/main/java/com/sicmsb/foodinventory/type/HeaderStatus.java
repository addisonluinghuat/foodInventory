package com.sicmsb.foodinventory.type;

public enum HeaderStatus {
	SUCCESS("success"),

	ERROR("error");

	private String status;

	private HeaderStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}