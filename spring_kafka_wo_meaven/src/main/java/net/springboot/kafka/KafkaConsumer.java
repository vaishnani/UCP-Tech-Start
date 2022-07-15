package net.springboot.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics="javaTopic", groupId = "myGroup")
	public void Consume(String msg) {
		System.out.println("Recived Messgae is "+msg);
	}
}
