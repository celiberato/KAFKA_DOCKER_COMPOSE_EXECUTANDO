package com.interview.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("server")
public class ServerConfig {

	@Value("${server.port}")
	private int port;

	@Value("${server.address}")
	private String address;
    
	@Value("${server.servlet.context-path}")
	private String contextPath;

    // Getters and Setters
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = 9081;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = "/kafka-demo";
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = "localhost";
	}
    
    
}