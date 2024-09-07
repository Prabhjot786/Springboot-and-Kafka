package com.loyalistcollege.kafkademo;

import org.apache.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangeHandler implements EventHandler {

	private static final Logger LOGGER = Logger.getLogger("WikimediaChangeHandler");

	private KafkaTemplate<String, String> kafkaTemplate;
	private String topic;

	public WikimediaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {

		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessage(String s, MessageEvent messageEvent) throws Exception {

		LOGGER.info(String.format("event data -> %s", messageEvent.getData()));
		kafkaTemplate.send(topic, messageEvent.getData());

	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub

	}

}
