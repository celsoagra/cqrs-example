package me.celso.agra.service;

import java.io.IOException;

import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import me.celso.agra.model.Information;

@Service
public class KafkaConsumerService {

	private final Logger logger = LoggerFactory.getLogger(Producer.class);

	@Autowired
	InformationReadService readService;

	@KafkaListener(topics = "test", groupId = "group_id")
	public void consume(Information data) throws IOException {
		logger.info(String.format("#### -> Consumed message -> %s", data.toString()));
		readService.add(data);
	}
}
