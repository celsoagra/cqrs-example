package me.celso.agra.service;

import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import me.celso.agra.model.Information;

@Service
public class KafkaProducerService {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "test";

	@Autowired
	private KafkaTemplate<String, Information> kafkaTemplate;

	public void sendMessage(Information info) {
		logger.info(String.format("#### -> Producing message -> %s", info.toString()));
		this.kafkaTemplate.send(TOPIC, info);
	}
}
