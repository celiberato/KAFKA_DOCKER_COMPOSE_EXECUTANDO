package com.interview.demo.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaDemoConsumer {

    public String executar() {
        String bootstrapServers = "localhost:9092";
        String groupId = "test-consumidor";
        String topic = "test-topic";

        Properties props = new Properties();
        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));

        StringBuffer sb = new StringBuffer();
        
        sb.append("[CONSUMINDO PRÓXIMAS 10 MENSAGENS]: tópico: " + topic);
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
        
        for (ConsumerRecord<String, String> record : records) {
        	
        	String result = 
        			String.format("<br/>[RECEBIDO]: chave=%s, valor=%s, partição=%d, offset=%d%n",
                    record.key(), record.value(), record.partition(), record.offset());
        	
        	sb.append(result);
        }
        return sb.toString();
    }
}