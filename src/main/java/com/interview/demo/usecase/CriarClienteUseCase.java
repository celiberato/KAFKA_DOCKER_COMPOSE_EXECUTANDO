package com.interview.demo.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.demo.entity.Cliente;
import com.interview.demo.enumeration.StatusEnum;
import com.interview.demo.model.response.ClienteResponse;
import com.interview.demo.repository.ClienteRepository;

@Service
public class CriarClienteUseCase {
	
	@Autowired
	private ClienteRepository repository;

    public ClienteResponse execute(Cliente request) {
        Cliente cliente = new Cliente(request.getNome(), request.getEmail());
        
        cliente.setStatus(StatusEnum.CRIADO);
        
        repository.save(cliente);
        
        return new ClienteResponse(
        		cliente.getId(), 
        		cliente.getNome(),
        		cliente.getEmail());
    }
}