package com.interview.demo.entity;

import com.interview.demo.enumeration.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente", catalog = "testdb")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
    private StatusEnum status;

    
    public Cliente(long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		
	}

    public Cliente(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public Cliente() {
		super();
	}

	// Getters e Setters
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

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
    
	
    
}