package com.algaworks.algalog.api.mappers;

import com.algaworks.algalog.api.resources.ClienteResource;
import com.algaworks.algalog.domain.model.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ClienteMapper {
	
	public Collection<ClienteResource> toCollection(Collection<Cliente> clientes) {
        return clientes.stream()
                .map(this::toResource)
                .collect(Collectors.toList());
    }

    public Cliente toEntity(ClienteResource resource) {
        return modelMapper.map(resource, Cliente.class);

    }

    public ClienteResource toResource(Cliente entity) {
        return modelMapper.map(entity, ClienteResource.class);
    }

    private ModelMapper modelMapper;

}
