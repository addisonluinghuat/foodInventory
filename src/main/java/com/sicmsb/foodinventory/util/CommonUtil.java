package com.sicmsb.foodinventory.util;

import com.sicmsb.foodinventory.model.payload.request.Header;
import com.sicmsb.foodinventory.model.payload.response.ResponseBase;
import com.sicmsb.foodinventory.model.payload.response.ResponseError;
import com.sicmsb.foodinventory.model.payload.response.ResponseHeader;
import com.sicmsb.foodinventory.type.HeaderStatus;

public class CommonUtil {

	public static <T> ResponseBase<T> genResponseBase(Header header) {
		ResponseBase<T> responseBase = new ResponseBase<>();
		ResponseHeader responseHeader = new ResponseHeader();
		responseHeader.setAppVersion("1.0");
		responseHeader.setStatus(HeaderStatus.SUCCESS.getStatus());
		responseBase.setHeader(responseHeader);
		return responseBase;
	}

	public static <T> ResponseBase<T> genErrorResponseBase(String appVersion, String code, String msg) {

		ResponseBase<T> responseBase = new ResponseBase<>();
		ResponseHeader responseHeader = new ResponseHeader();
		ResponseError responseError = new ResponseError();

		responseError.setCode(code);
		responseError.setMessage(msg);
		responseHeader.setAppVersion("1.0");
		responseHeader.setStatus(HeaderStatus.ERROR.getStatus());
		responseHeader.setError(responseError);
		responseBase.setHeader(responseHeader);
		return responseBase;
	}

}
