package com.tanthanh.notificationservice;

import org.apache.kafka.common.protocol.Message;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@SpringBootApplication
@RestController
@EnableBinding(Sink.class)
public class NotificationserviceApplication {
	private Logger logger =org.slf4j.LoggerFactory.getLogger(NotificationserviceApplication.class);

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;


	@StreamListener(Sink.INPUT)
	public void consumeMessage(Message message) {

		System.out.println("Message" + message);
	}


	public static void main(String[] args) {
		SpringApplication.run(NotificationserviceApplication.class, args);
	}


}