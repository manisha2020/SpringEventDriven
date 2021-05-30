/**
 * 
 * @author manishanikambe
 * Hotel Booking Rabbit MQ Messaging application start class
 */
package com.spring.message;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MessageProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageProducerApplication.class, args);
	}

	private static final String QUEUE_NAME = "rooms-cleaner1";
	private static final String EXCHANGE_NAME = "operations";
	private static final String ROUTING_KEY = "message_key";

	/**
	 * Creating Queue
	 * 
	 * @return
	 */
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	/**
	 * Creating exchange object
	 * 
	 * @return
	 */
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(EXCHANGE_NAME);
	}

	/**
	 * Biding Bean
	 * @param queue
	 * @param exchange
	 * @return
	 */
	@Bean
	public Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

}
