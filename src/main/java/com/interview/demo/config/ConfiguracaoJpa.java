package com.interview.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.interview.demo.repository.*")
@ComponentScan(basePackages = { "com.interview.demo.usecase.*" })
@EntityScan("com.interview.demo.entity.*")
public class ConfiguracaoJpa {
}