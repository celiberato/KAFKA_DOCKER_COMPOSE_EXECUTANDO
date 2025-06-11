package com.interview.demo.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.demo.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ApagarClienteUseCase {

	@Autowired
	private ClienteRepository repository;

	@Transactional
	public void execute(Long id) {
		if (id==null) {
			throw new IllegalArgumentException("Para deleção do cliente é necessário informar o ID do cliente!");
		}

		repository.deleteById(id);
	}

}
