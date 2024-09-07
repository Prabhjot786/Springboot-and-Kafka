package com.loyalist.onlinemoviebookingsystem;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loyalist.onlinemoviebookingsystem.dto.User;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER = Logger.getLogger(JsonKafkaProducer.class.getName());
	
	@Autowired
	private ObjectMapper objectMapper; 

	@Autowired
	private KafkaTemplate<String, Object> template;

	public CompletableFuture<SendResult<String, Object>> future;

	public void sendMessage(String message) {

		// LOGGER.info(String.format("Message sent -> %s", data));
		future = template.send("topic", message);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println("sent Message" + message + "with Offset" + result.getRecordMetadata().offset());
			} else {
				System.out.println("unable to sent message due to " + ex.getMessage());
			}
		});

	}
	
	
	public void sendEventsToTopic(User user) {
        String userJson;
		try {
			userJson = objectMapper.writeValueAsString(user);
			  future = template.send("demoTopic", userJson);

				// LOGGER.info(String.format("Message sent -> %s", data));
				//future = template.send("demoTopic", std.toString());
				future.whenComplete((result, ex) -> {
					if (ex == null) {
						System.out.println("sent Message" + userJson + "with Offset" + result.getRecordMetadata().offset());
					} else {
						System.out.println("unable to sent message due to " + ex.getMessage());
					}
				});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      

	}
}
