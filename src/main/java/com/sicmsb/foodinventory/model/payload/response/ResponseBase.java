package com.sicmsb.foodinventory.model.payload.response;

public class ResponseBase<T> {

	ResponseHeader header;
	T payload;

	public ResponseHeader getHeader() {
		return header;
	}

	public void setHeader(ResponseHeader header) {
		this.header = header;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

}
