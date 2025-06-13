package com.interview.demo.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaDemoConsumer {

    public String executar() {
        String bootstrapServers = "localhost:9092";
        String groupId = "test-consumidor";
        String topic = "test-topic";

        Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); 
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        
        StringBuilder sb;
		try {
			KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
			consumer.subscribe(Collections.singletonList(topic));
			consumer.seekToBeginning(consumer.assignment());

			sb = new StringBuilder();
			
			sb.append("[CONSUMINDO PRÓXIMAS MENSAGENS]: tópico: " + topic);
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(2000));

			sb.append("<br/> >>> PASSO 1");
			java.util.Map<String,java.util.List<PartitionInfo>> listTopics = consumer.listTopics();
			System.out.println("list of topic size :" + listTopics.size());
			for(String topic2 : listTopics.keySet()){
			    System.out.println("topic name :"+topic2);
			}

			sb.append("<br/> >>> PASSO 2");
			
			sb.append(records.count());
			
			sb.append("<br/> >>> PASSO 3");

			for (ConsumerRecord<String, String> record : records) {
				      	
			    sb.append("<br/> >>> PASSO 4");
				
				String result = 
						String.format("<br/>[RECEBIDO]: chave=%s, valor=%s, partição=%d, offset=%d%n",
			            record.key(), record.value(), record.partition(), record.offset());
				
				sb.append(result);
			}
			
			sb.append("<br/> >>> PASSO 5");
		} catch (Exception e) {
			throw new RuntimeException(">>>>>> " + e.getMessage());
		}
        
        return sb.toString();
    }
}