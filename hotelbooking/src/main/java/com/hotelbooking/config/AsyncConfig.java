/**
 * @author manishanikambe
 * Configuration class which has required dependency of beans 
 */
package com.hotelbooking.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hotelbooking.async.RoomCleanerListener;

@Configuration
public class AsyncConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(RoomCleanerListener.class);
	private static final String QUEUE_NAME = "rooms-cleaner1";
	private static final String EXCHANGE_NAME = "operations";
	private static final String ROUTING_KEY = "message_key";
	private static final String RECEIVE_MESSAGE = "receiveMessage";
	
	/**
	 * Creating Queue 
	 * @return
	 */
	@Bean
	public Queue queue()
	{
		logger.info("creating Queue :" + QUEUE_NAME);
		return new Queue(QUEUE_NAME,false);
	}
	
	/**
	 * Creating exchange object 
	 * @return
	 */
	@Bean
	public DirectExchange exchange()
	{
		logger.info("creating TopicExchange :" + EXCHANGE_NAME);
		return new DirectExchange(EXCHANGE_NAME);
	}

	/**
	 * Binding Queue and Exchange 
	 * @param queue
	 * @param exchange
	 * @return
	 */
	@Bean
	public Binding binding(Queue queue,DirectExchange exchange)
	{
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	/**
	 * Listener adapter which will consume RoomLeanerListener
	 * @param listner
	 * @return
	 */
	@Bean
	public MessageListenerAdapter listenerApapter(RoomCleanerListener listner)
	{
		return new MessageListenerAdapter(listner, RECEIVE_MESSAGE);
	}
	
	/**
	 * Finally a container which binds all required configuration of beans together
	 * @param connectionFactory
	 * @param listernerAdapter
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listernerAdapter)
	{
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE_NAME);
		container.setMessageListener(listernerAdapter);
		return container;
	}
}
