package com.demo.kafka.config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import lombok.extern.slf4j.Slf4j;


@Configuration
@Slf4j
public class KafkaTopicConfig {

	@Value("${kafka.bootstrap-servers}")
	private String bootstrapServer;

	private static final int ADMIN_CLIENT_TIMEOUT_MS = 30000;

	public <T> ProducerFactory<String, T> producerFactory() {
		log.info("bootstap server :- {} ", this.bootstrapServer);
		final Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServer);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		try (AdminClient client = AdminClient.create(configProps)) {
			client.listTopics(new ListTopicsOptions().timeoutMs(ADMIN_CLIENT_TIMEOUT_MS)).listings().get();

		} catch (ExecutionException | InterruptedException ex) {
			log.error("Kafka is not available, timed out after ms {}", ADMIN_CLIENT_TIMEOUT_MS);
			Thread.currentThread().interrupt();
			System.exit(0);
		}
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	public <T> KafkaTemplate<String, T> kafkaTemplate() {
		return new KafkaTemplate<>(this.producerFactory());
	}
}
