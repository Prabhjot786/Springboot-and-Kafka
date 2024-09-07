package com.loyalist.onlinemoviebookingsystem;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    NewTopic movieUserTopic() {
        return TopicBuilder.name("Users").build();
    }

    @Bean
    NewTopic JsonMoviebookingTopic() {
       
    	return TopicBuilder.name("Users_json").build();
    }
    
    @Bean
    NewTopic demoTopic() {
        return TopicBuilder.name("demoTopic").build();
    }
}
