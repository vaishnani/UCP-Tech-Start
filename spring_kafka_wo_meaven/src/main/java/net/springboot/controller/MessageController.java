package net.springboot.controller;

import java.net.InetSocketAddress;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.kafka.KafkaProducer;

@RestController
@RequestMapping("/")
public class MessageController {
	
	private KafkaProducer kafkaProducer;
	
	public MessageController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@GetMapping("/query")
	public ResponseEntity<String> getQuery(@RequestParam("message") String msg){
		kafkaProducer.sendMessage(msg);
		return new ResponseEntity<String>(String.format("Send message is %s", msg), HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> getBody(@RequestBody String body, @RequestHeader("content-type") String header_c, @RequestHeader HttpHeaders headers, @RequestHeader("connection") String header_conn) {
		
		
		InetSocketAddress host = headers.getHost();
	    String url = "http://" + host.getHostName() + ":" + host.getPort();
	    
	    kafkaProducer.sendMessage(String.format("Body is: %s", body));
		kafkaProducer.sendMessage(String.format("content-type = %s", header_c));
		kafkaProducer.sendMessage(String.format("Base URL = %s", url));
		kafkaProducer.sendMessage(String.format("Connection is %s", header_conn));
		
		return new ResponseEntity<String>("Messages sent successfully", HttpStatus.OK);
	}
}