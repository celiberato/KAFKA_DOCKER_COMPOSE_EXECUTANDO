package com.interview.demo.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

	private Long id;

	@NotBlank(message = "Nome do produto deve ser informado!")
	private String nome;

	@NotBlank(message = "Email do cliente deve sr informado!")
	private String email;
	
	public ClienteRequest() {
		super();
	}	

	public ClienteRequest(Long id,
			@NotBlank(message = "Nome do produto não pode estar nulo!") String name){
		super();
		this.id = id;
		this.nome = nome;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
