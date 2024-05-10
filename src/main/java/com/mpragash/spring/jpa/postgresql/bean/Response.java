package com.mpragash.spring.jpa.postgresql.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {
	
	private T data;
	private String message;
	private boolean isSuccess;

	public Response() {
		super();
	}
	
	public Response(T data, String message, boolean isSuccess) {
		super();
		this.message = message;
		this.isSuccess = isSuccess;
		this.data = data;
	}

	public Response(String message, boolean isSuccess) {
		super();
		this.message = message;
		this.isSuccess = isSuccess;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}