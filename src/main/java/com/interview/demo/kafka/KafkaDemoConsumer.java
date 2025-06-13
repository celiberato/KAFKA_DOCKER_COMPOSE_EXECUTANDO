package com.interview.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaDemoConsumer {

    @KafkaListener(topics = "test-topic", groupId = "test-consumidor")
    public void consumirMensagem(String mensagem) {
        System.out.println(">>>>>>>>>>>> Mensagem recebida: " + mensagem);
    }
}