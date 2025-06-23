package com.interview.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.kafka.KafkaDemoProducer;
import com.interview.demo.repository.ClienteRepository;
import com.interview.demo.usecase.ListarClientesUseCase;
import com.interview.demo.utils.mapper.ClienteMapper;

@RestController
@RequestMapping(value = {"/kafka"})
public class KafkaController {

	ClienteMapper mapper = new ClienteMapper();

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private ListarClientesUseCase listarClientes;

	
	@GetMapping("/produzir")
	public String produzir() {
		KafkaDemoProducer producer = new KafkaDemoProducer();
		
		return producer.executar();
	}

	@GetMapping("/nada")
	public String nada() {
		return "OK!";
	}

}