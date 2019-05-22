package com.sicmsb.foodinventory.exception;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sicmsb.foodinventory.model.payload.request.RequestBase;
import com.sicmsb.foodinventory.model.payload.request.RequestContext;
import com.sicmsb.foodinventory.model.payload.response.ResponseBase;
import com.sicmsb.foodinventory.util.CommonUtil;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Inject
	private RequestContext requestContext;

	private static final Logger log = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

	@ExceptionHandler(value = { BaseException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected <T> ResponseEntity<Object> handleConflict(BaseException e) {
		Object request = requestContext.getRequestBody();
		@SuppressWarnings("unchecked")
		RequestBase<T> requestBase = (RequestBase<T>) request;

		ResponseBase<T> responseBase = CommonUtil.genErrorResponseBase("2.0", String.valueOf(e.getCode()),
				e.getMessage());
		return new ResponseEntity<Object>(responseBase,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	protected <T> ResponseEntity<Object> globalConflict(Exception e) {

		Object request = requestContext.getRequestBody();
		@SuppressWarnings("unchecked")
		RequestBase<T> requestBase = (RequestBase<T>) request;
		log.error("Internal Server Error:{}", e.getMessage());
		ResponseBase<T> responseBase = CommonUtil.genErrorResponseBase("1.0", "500", "Interal Server error");

		return new ResponseEntity<Object>(responseBase,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
