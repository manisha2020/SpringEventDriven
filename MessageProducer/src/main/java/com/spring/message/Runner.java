/**
 * 
 * @author manishanikambe
 * Runner class -Message Producer
 */
package com.spring.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Runner implements CommandLineRunner{

	private final RabbitTemplate rabbitTemplate;
	private final ObjectMapper objectMapper;
	
	private static final String ROOM = "ROOM";
	private static final String OPERATION = "operations";
	private static final String MESSAGE_KEY = "message_key";
	
	
	public Runner(RabbitTemplate rabbitTemplate,ObjectMapper objectMapper)
	{
		this.rabbitTemplate = rabbitTemplate;
		this.objectMapper = objectMapper;
	}
	@Autowired
	private ConfigurableApplicationContext context;
	
	@Override
	public void run(String... args) throws Exception {
		int index = (int) ((Math.random()*(14-1))+1);
		AsyncPayload payLoad = new AsyncPayload();
		payLoad.setId(index);
		payLoad.setModel(ROOM);
		rabbitTemplate.convertAndSend(OPERATION, MESSAGE_KEY, objectMapper.writeValueAsString(payLoad));
		context.close();
	}
}
