package com.demo.service2.config;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaListenerDemo {

	//	@Autowired
	//	private KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = "testDemo")
	public void listen(String message) {
		System.out.println("Received Messasge in group " + message);
	}
}
