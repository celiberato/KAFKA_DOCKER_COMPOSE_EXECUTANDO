package com.interview.demo.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaDemoProducer { 
	
	public String enviar() {
		Properties props = new Properties(); 
		props.put("bootstrap.servers", "localhost:9092"); 
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


	    KafkaProducer<String, String> producer = new KafkaProducer<>(props);
	    producer.send(new ProducerRecord<>("my-topic", "key", "Hello world!"));
	    producer.close();
	    
	    return "OK";
	}

}