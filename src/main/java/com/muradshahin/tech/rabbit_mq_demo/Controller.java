package com.muradshahin.tech.rabbit_mq_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.muradshahin.tech.rabbit_mq_demo.pojos.GenericResponse;
import com.muradshahin.tech.rabbit_mq_demo.pojos.MessagePojo;

@RestController
public class Controller {

	@Autowired
	RabbitMqProducer rabbitMqProducer;

	@PostMapping("/message")
	public ResponseEntity<GenericResponse> postMessage(@RequestBody MessagePojo messageRequest) {

		try {

			System.out.println("inside message flow");
			rabbitMqProducer.sendMessage(messageRequest);

			System.out.println("inside message flow2");
			return new ResponseEntity<>(new GenericResponse("message sent successfullt", messageRequest),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new GenericResponse("error while sending the message", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
