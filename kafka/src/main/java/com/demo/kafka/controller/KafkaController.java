package com.demo.kafka.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafka.model.SendDataToKafka;
import com.demo.kafka.service.KafkaService;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

	@Autowired
	private KafkaService kafkaService;

	@PostMapping("/sendDataToKafka")
	public <T> boolean sendDataToKafka(@RequestBody SendDataToKafka sendDataToKafka, @RequestParam("topicName") String topicName) throws InterruptedException, ExecutionException {
		return this.kafkaService.sendDataToKafka(topicName, sendDataToKafka);
	}
}
