package com.sicmsb.foodinventory.model.payload.response;

public class Response {
	private ResponseHeader header;
	private Object payload;

	public ResponseHeader getHeader() {
		return header;
	}

	public void setHeader(ResponseHeader header) {
		this.header = header;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

}
