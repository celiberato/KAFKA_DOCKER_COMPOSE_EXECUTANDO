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
	    
	    StringBuffer sb = new StringBuffer();
	    for (int i=0; i<10; i++) {
		    producer.send(new ProducerRecord<>("test-topic", "key", "Hello world! " + i));
		    
		    sb.append("/n >>> Hello world! " + i);
	    }
	    producer.close();
	    
	    return sb.toString();
	}

}