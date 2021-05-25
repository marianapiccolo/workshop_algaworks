package com.algaworks.algalog.api.mappers;

import com.algaworks.algalog.api.resources.DestinatarioResource;
import com.algaworks.algalog.api.resources.EntregaResource;
import com.algaworks.algalog.domain.model.Destinatario;
import com.algaworks.algalog.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaMapper {
	
	 private ModelMapper modelMapper;

	    public Collection<EntregaResource> toCollection(Collection<Entrega> entregas) {
	        return entregas.stream()
	                .map(this::toResource)
	                .collect(Collectors.toList());
	    }

	    public Entrega toEntity(EntregaResource resource) {
	        final var destinatarioResource = resource.getDestinatario();
	        final var entrega = modelMapper.map(resource, Entrega.class);
	        entrega.setDestinatario(modelMapper.map(destinatarioResource, Destinatario.class));
	        return entrega;

	    }

	    public EntregaResource toResource(Entrega entity) {
	        final var destinatario = entity.getDestinatario();
	        final var entregaResource = modelMapper.map(entity, EntregaResource.class);
	        entregaResource.setDestinatario(modelMapper.map(destinatario, DestinatarioResource.class));
	        return entregaResource;
	    }

}
