package com.interview.demo.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaDemoProducer { 
	
	public String executar() {
		Properties props = new Properties(); 
		props.put("bootstrap.servers", "localhost:9092"); 
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

	    KafkaProducer<String, String> producer = new KafkaProducer<>(props);
	    
	    StringBuffer sb = new StringBuffer();
	    for (int i=0; i<10; i++) {
	    	String result = Math.random() + "@gmail.com-Flavio Santos " + Math.random();
		    
	    	producer.send(new ProducerRecord<>("test-topic", "key", result));
		        	
		    sb.append(result + "<b/>");
	    }
	    producer.close();
	    
	    System.out.print(sb.toString());
	    
	    return sb.toString();
	}

}