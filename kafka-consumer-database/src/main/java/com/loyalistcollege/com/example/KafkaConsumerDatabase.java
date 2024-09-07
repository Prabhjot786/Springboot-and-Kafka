package com.loyalistcollege.com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.loyalistcollege.com.repository.WikimediaDataRepository;

@Service
public class KafkaConsumerDatabase {

	@Autowired
	WikimediaDataRepository wikimediaDataRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerDatabase.class);

	@KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
	public void consume(String eventMessage) {
		WikimediaEntity wikimediaEntity=new WikimediaEntity();
		wikimediaEntity.setWikiEventData(eventMessage);
		wikimediaDataRepository.save(wikimediaEntity);
		LOGGER.info(String.format("Event message recieved -> %s", eventMessage));

	}

}
