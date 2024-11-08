package com.muradshahin.tech.rabbit_mq_demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muradshahin.tech.rabbit_mq_demo.pojos.MessagePojo;

@Service
public class RabbitMqProducer {

	private RabbitTemplate rabbitTemplate;

	private Jackson2JsonMessageConverter jackson2JsonMessageConverter;

	private String exchange = "amq.match";
	private String routingKey = "sms.req.msg";

	/**
	 * The @Autowired annotation tells Spring to automatically inject a bean into
	 * this class’s constructor. Here, @Autowired is applied to the constructor,
	 * meaning Spring will inject an instance of RabbitTemplate when it creates an
	 * instance of RabbitMQProducer. When a class is annotated with @Autowired,
	 * Spring searches for an existing bean of the required type (here,
	 * RabbitTemplate) in the application context. If found, it will pass that bean
	 * to the constructor. This allows for loose coupling, as RabbitMQProducer
	 * doesn’t have to explicitly instantiate RabbitTemplate itself. Spring handles
	 * the lifecycle and injection, so RabbitMQProducer just "depends" on it.
	 */

	@Autowired
	public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		this.jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();

	}

	public void sendMessage(MessagePojo message) {

		System.out.println("sendMessage flow");

		rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
		
		MessagePojo queueResponse =(MessagePojo) rabbitTemplate.receiveAndConvert(routingKey);
		
		System.out.println("after receiving");
		System.out.println(queueResponse.toString());

	}

}
