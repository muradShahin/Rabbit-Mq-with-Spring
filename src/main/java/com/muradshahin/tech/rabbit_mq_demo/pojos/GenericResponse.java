package com.muradshahin.tech.rabbit_mq_demo.pojos;

public class GenericResponse {

	public String responseDescription;
	public Object responseContext;

	public GenericResponse(String responseDescription, Object responseContext) {
		super();
		this.responseDescription = responseDescription;
		this.responseContext = responseContext;
	}

}
