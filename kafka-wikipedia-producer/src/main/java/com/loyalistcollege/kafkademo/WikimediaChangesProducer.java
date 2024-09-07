package com.loyalistcollege.kafkademo;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaChangesProducer {

	private static final Logger LOGGER = Logger.getLogger("WikimediaChangesProducer");

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage() throws InterruptedException {
		String topic = "wikimedia_recentChange";

		// to read realtime stream data from wikimedia we use event source
		EventHandler eventHandler = new WikimediaChangeHandler(kafkaTemplate, topic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";

		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource = builder.build();
		eventSource.start();
		TimeUnit.MINUTES.sleep(10);
	}
}
