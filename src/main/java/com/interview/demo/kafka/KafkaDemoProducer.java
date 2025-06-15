package com.interview.demo.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;

@Component
public class KafkaDemoProducer { 
	
	public String executar() {
		Properties props = new Properties(); 
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); 
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
       
		
	    KafkaProducer<String, String> producer = new KafkaProducer<>(props);
	    
	    StringBuffer sb = new StringBuffer();
	    for (int i=0; i<10; i++) {
	    	String result = Math.random() + "@gmail.com-Flavio Santos " + Math.random();
		    
	    	producer.send(new ProducerRecord<>("test-topic", "key", result));
		        	
		    sb.append(result + "\\n");
	    }
	    producer.close();
	    
	    System.out.print(sb.toString());
	    
	    return sb.toString();
	}

}