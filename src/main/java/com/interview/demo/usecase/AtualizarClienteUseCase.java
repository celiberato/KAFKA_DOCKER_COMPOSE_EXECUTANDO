package com.interview.demo.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.demo.entity.Cliente;
import com.interview.demo.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class AtualizarClienteUseCase {

	@Autowired
	private ClienteRepository repository;


    public AtualizarClienteUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

	@Transactional
    public Cliente execute(Cliente request) {
        Cliente cliente = new Cliente(request.getNome(), request.getEmail());
        
        repository.save(cliente);
        
        return new Cliente(
        		cliente.getId(), 
        		cliente.getNome(), 
        		cliente.getEmail());
    }

}
