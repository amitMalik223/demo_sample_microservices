package com.demo.kafka.service;

import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.kafka.model.SendDataToKafka;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaService {

	@Resource(name = "kafkaTemplate")
	private KafkaTemplate<String, Object> kafkaTemplate;

	/**
	 * @param <T>
	 * @description use to produce data in kafka server, also checks if topic is
	 *              having partition or not and work accordingly.
	 * @param : topic
	 * @param : key (optional)
	 * @param : data
	 * @return : true or false
	 */
	public <T> boolean sendDataToKafka(String topic, SendDataToKafka sendDataToKafka) throws InterruptedException, ExecutionException {
		log.info("sending data 1: {} of topic: {}", sendDataToKafka, topic);
		try {
			log.info("sending data 3: {} of topic: {}", sendDataToKafka, topic);
			this.kafkaTemplate.send(topic, sendDataToKafka.toString());
			this.kafkaTemplate.flush();
			return true;
		} catch (final Exception e) {
			log.error("topic name is not in topic map , check producer properties file{}", e);
		}
		return false;
	}
}
