package com.interview.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.interview.demo.entity.Cliente;
import com.interview.demo.enumeration.StatusEnum;
import com.interview.demo.usecase.CriarClienteUseCase;
import com.interview.demo.usecase.ListarClientesUseCase;

@Component
public class KafkaDemoConsumer {

	@Autowired
	private CriarClienteUseCase criarClientes;

	@Autowired
	private ListarClientesUseCase listarClientes;
	
    @KafkaListener(topics = "test-topic", groupId = "test-consumidor")
    public void consumirMensagem(String mensagem) {
        System.out.println(">>> [MENSAGEM RECEBIDA]: " + mensagem);
        
        Cliente cliente = new Cliente();
        cliente.setEmail(mensagem.split(";")[0]);
        cliente.setNome(mensagem.split(";")[1]);
        cliente.setStatus(StatusEnum.CRIADO);

        criarClientes.execute(cliente);
        
    }
}