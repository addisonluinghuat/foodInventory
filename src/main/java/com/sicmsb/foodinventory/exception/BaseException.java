package com.sicmsb.foodinventory.exception;

public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	private final int code;
	private final String message;
	private final String fieldName;

	public BaseException(int code) {
		this.message = "";
		this.fieldName = "";
		this.code = code;
	}

	public BaseException(int code, String message) {
		this.message = message;
		this.fieldName = "";
		this.code = code;
	}

	public BaseException(String fieldName, int code) {
		this.message = "";
		this.fieldName = fieldName;
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public String getFieldName() {
		return fieldName;
	}

}
