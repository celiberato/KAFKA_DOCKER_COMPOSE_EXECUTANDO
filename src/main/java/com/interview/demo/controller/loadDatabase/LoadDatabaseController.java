package com.interview.demo.controller.loadDatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.entity.Cliente;
import com.interview.demo.model.response.ClienteResponse;
import com.interview.demo.repository.ClienteRepository;
import com.interview.demo.usecase.ListarClientesUseCase;
import com.interview.demo.utils.mapper.ClienteMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = {"/carregar"})
@Tag(name = "Produtos", description = "Operações relacionadas a produtos")
public class LoadDatabaseController {

	ClienteMapper mapper = new ClienteMapper();

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private ListarClientesUseCase listarClientes;

	
	@GetMapping("/todos")
	@Operation(summary = "Busca um produto pelo ID", description = "Retorna um produto específico pelo ID")
	public ResponseEntity<List<ClienteResponse>> loadData() {
		repository.save(new Cliente(null, "JOSÉ"));
		repository.save(new Cliente(null, "MARELO"));
		repository.save(new Cliente(null, "RICARDO"));
		repository.save(new Cliente(null, "DANIEL"));
		repository.save(new Cliente(null, "RFAEL"));
		
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toListaResponse(
						listarClientes.execute()));

	}

}