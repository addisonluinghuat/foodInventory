package com.sicmsb.foodinventory.type;

public enum HeaderStatus {

	SUCCESS("200", "success");

	private final String code;
	private final String description;

	private HeaderStatus(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}