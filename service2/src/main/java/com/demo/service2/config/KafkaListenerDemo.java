package com.demo.service2.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerDemo {

	//	@Autowired
	//	private KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = "testDemo", groupId = "mygroup")
	public void listen(String message) {
		System.out.println("Received Messasge in group " + message);
	}
}
