package com.sicmsb.foodinventory.type;

public enum RoleType {

	ADMIN("ADMIN", "Admin");

	private final String code;
	private final String description;

	private RoleType(String code, String description) {
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