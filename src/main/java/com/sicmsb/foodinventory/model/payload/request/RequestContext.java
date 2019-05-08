package com.sicmsb.foodinventory.model.payload.request;

import javax.annotation.ManagedBean;

import org.springframework.web.context.annotation.RequestScope;

@ManagedBean
@RequestScope
public class RequestContext {

	Object requestBody;

	public Object getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(Object requestBody) {
		this.requestBody = requestBody;
	}

}
