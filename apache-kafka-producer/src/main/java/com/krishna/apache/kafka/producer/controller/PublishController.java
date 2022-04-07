package com.krishna.apache.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.apache.kafka.producer.vo.Book;

@RestController
public class PublishController {
	
	@Autowired
	KafkaTemplate<String, Book> kafkaTemplate;
	
	private static final String TOPIC = "NewTopic";
	
	@GetMapping("/publish/{message}")
	public String publishMessage(@PathVariable("message") String message) {
		//kafkaTemplate.send(TOPIC, message);
		return "Published successfully";
	}
	
	@PostMapping("/publish")
	public String publishBook(@RequestBody Book book) {
		kafkaTemplate.send(TOPIC, book);
		return "Published successfully";
	}
}
