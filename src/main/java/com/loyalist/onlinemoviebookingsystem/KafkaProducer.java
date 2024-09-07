package com.loyalist.onlinemoviebookingsystem;

//Java program to demonstrate 
//Logger.getLogger(java.lang.String) method 
import java.util.logging.Logger;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
/*
 * @Service public class KafkaProducer { private KafkaTemplate<String, String>
 * KafkaTemplate;
 * 
 * private static final Logger LOGGER =
 * Logger.getLogger(KafkaProducer.class.getName()); public
 * KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
 * this.KafkaTemplate=kafkaTemplate; }
 * 
 * public void sendMessage(String message) { LOGGER.info(message);
 * KafkaTemplate.send("Movies",message); }
 * 
 * }
 */
