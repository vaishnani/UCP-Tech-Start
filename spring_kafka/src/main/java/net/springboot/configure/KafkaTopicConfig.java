package net.springboot.configure;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	public NewTopic javaTopic() {
		return TopicBuilder.name("javaTopic")
				.build();
	}
}
