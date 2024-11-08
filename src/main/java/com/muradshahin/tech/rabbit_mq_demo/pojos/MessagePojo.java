package com.muradshahin.tech.rabbit_mq_demo.pojos;

import java.io.Serializable;

public class MessagePojo {

	private String messageContext;
	private String receiverNumber;

	public String getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(String messageContext) {
		this.messageContext = messageContext;
	}

	public String getReceiverNumber() {
		return receiverNumber;
	}

	public void setReceiverNumber(String receiverNumber) {
		this.receiverNumber = receiverNumber;
	}

}
