package com.krishna.apache.kafka.consumer.consume;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "NewTopic", groupId = "listening_group")
	public void consume(String message) {
		System.out.println("message = "+message);
	}
}
