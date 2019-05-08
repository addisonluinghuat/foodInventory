package com.sicmsb.foodinventory.model.payload.request;

import javax.validation.Valid;

public class RequestBase<T> {

	@Valid
	private Header header;

	@Valid
	private T payload;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
}
