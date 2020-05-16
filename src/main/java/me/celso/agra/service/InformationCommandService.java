package me.celso.agra.service;

import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.celso.agra.model.Information;
import me.celso.agra.repository.InformationRepository;

@Service
public class InformationCommandService {
	
	@Autowired
	InformationRepository repository;
	
	@Autowired
	KafkaProducerService messageProducerService;
	
	public Information create(Information message) {
		Information messagePersisted = repository.save(message);
		
		if (messagePersisted.isPersisted()) {
			messageProducerService.sendMessage(message);
		} else {
			throw new PersistentObjectException(message.toString());
		}
		
		return message;
	}
}
