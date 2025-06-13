package com.interview.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.entity.Cliente;
import com.interview.demo.kafka.KafkaDemoConsumer;
import com.interview.demo.kafka.KafkaDemoProducer;
import com.interview.demo.model.response.ClienteResponse;
import com.interview.demo.repository.ClienteRepository;
import com.interview.demo.usecase.ListarClientesUseCase;
import com.interview.demo.utils.mapper.ClienteMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = {"/kafka"})
@Tag(name = "Kafka", description = "Produz e consome mensagens via kafka")
public class KafkaController {

	ClienteMapper mapper = new ClienteMapper();

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private ListarClientesUseCase listarClientes;

	
	@GetMapping("/produzir")
	@Operation(summary = "Produz mensagens Kafka", description = "Produz mensagens Kafka")
	public String produzir() {
		KafkaDemoProducer producer = new KafkaDemoProducer();
		
		return producer.executar();
	}

	@GetMapping("/nada")
	@Operation(summary = "Produs mensagens Kafka", description = "Produs mensagens Kafka")
	public String nada() {
		return "OK!";
	}

}
