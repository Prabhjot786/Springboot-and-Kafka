package com.loyalist.onlinemoviebookingsystem;

import java.util.logging.Logger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loyalist.onlinemoviebookingsystem.dto.Student;
import com.loyalist.onlinemoviebookingsystem.dto.User;

@Service
public class KafkaConsumer {

	private static final Logger LOGGER = Logger.getLogger(KafkaConsumer.class.getName());

	@KafkaListener(topics = "demoTopic", groupId = "myGroup")
	public void consume(String message) {
		
		try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        User user = objectMapper.readValue(message, User.class);
	        LOGGER.info(String.format("Message received -> %s",user.toString()));
	    } catch (JsonProcessingException e) {
	        Logger.getLogger(message, e.getMessage());
	    }
		
	}
}