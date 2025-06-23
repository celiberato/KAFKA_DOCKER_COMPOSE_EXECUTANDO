package com.interview.demo.utils.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.interview.demo.entity.Cliente;
import com.interview.demo.model.request.ClienteRequest;
import com.interview.demo.model.response.ClienteResponse;


public class ClienteMapper {

	static ModelMapper modelMapper = new ModelMapper();
	
	
    public Cliente toCliente(ClienteRequest clienteRequest){
    	return modelMapper.map(clienteRequest, Cliente.class);
    };

    public ClienteResponse toClienteResponse(Cliente cliente) {
    	return modelMapper.map(cliente, ClienteResponse.class);
	}
    
    
    public List<ClienteResponse> toListaResponse(List<Cliente> listaClientes) {
    	List<ClienteResponse> listaClientesResponse = new ArrayList<>();
    	for (Cliente cliente : listaClientes) {
    		
			listaClientesResponse.add(
					modelMapper.map(cliente, ClienteResponse.class));
		} 
    	
        return listaClientesResponse;
    }

    public List<Cliente> toListaClientes(List<ClienteRequest> listaClientesRequest) {
    	List<Cliente> listaClientes = new ArrayList<>();
    	for (ClienteRequest clienteRequest : listaClientesRequest) {
    		
    		listaClientes.add(
					modelMapper.map(clienteRequest, Cliente.class));
		} 
    	
        return listaClientes;
    }
}