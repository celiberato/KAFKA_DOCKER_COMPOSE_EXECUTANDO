package com.interview.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.model.request.ClienteRequest;
import com.interview.demo.model.response.ClienteResponse;
import com.interview.demo.repository.ClienteRepository;
import com.interview.demo.usecase.ApagarClienteUseCase;
import com.interview.demo.usecase.AtualizarClienteUseCase;
import com.interview.demo.usecase.ConsultarClienteUseCase;
import com.interview.demo.usecase.ListarClientesUseCase;
import com.interview.demo.usecase.CriarClienteUseCase;
import com.interview.demo.utils.mapper.ClienteMapper;



@RestController
@RequestMapping(value = {"/demo"})
public class ClienteController {

	ClienteMapper mapper = new ClienteMapper();


	@Autowired(required = true)
	private CriarClienteUseCase criarCliente;
	@Autowired
	private ListarClientesUseCase listarClientes;
	@Autowired
	private ConsultarClienteUseCase consultarCliente;
	@Autowired
	private AtualizarClienteUseCase atualizarCliente;
	@Autowired
	private ApagarClienteUseCase apagarCliente;

	@Autowired
	private ClienteRepository repository;

	@PostMapping("/criar")
	public ResponseEntity<ClienteResponse> criarCliente(@RequestBody @Validated ClienteRequest clienteRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(
			criarCliente.execute(
					mapper.toCliente(clienteRequest)));
	}

	@GetMapping("/todos")
	public ResponseEntity<List<ClienteResponse>> listarTodosClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toListaResponse(
						listarClientes.execute()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponse> getById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toClienteResponse(consultarCliente.execute(id))
		);
	}

	@PutMapping("{id}")
	public ResponseEntity<ClienteResponse> atualizarCliente(@RequestBody @Validated ClienteRequest clienteRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toClienteResponse(
					atualizarCliente.execute(mapper.toCliente(clienteRequest)))
		);
	}

	@DeleteMapping("/{id}")
	public void apagarCliente(@PathVariable Long id) {
		apagarCliente.execute(id);
	}

}
