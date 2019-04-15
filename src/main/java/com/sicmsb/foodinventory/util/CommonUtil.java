package com.sicmsb.foodinventory.util;

import com.sicmsb.foodinventory.model.payload.request.Header;
import com.sicmsb.foodinventory.model.payload.response.ResponseBase;
import com.sicmsb.foodinventory.model.payload.response.ResponseHeader;

public class CommonUtil {

	public static <T> ResponseBase<T> genResponseBase(Header header) {
		ResponseBase<T> responseBase = new ResponseBase<>();
		ResponseHeader responseHeader = new ResponseHeader();
		responseHeader.setAppVersion("1.0");
		responseHeader.setStatus(com.sicmsb.foodinventory.type.HeaderStatus.SUCCESS.getCode());
		responseBase.setHeader(responseHeader);
		return responseBase;
	}

}
