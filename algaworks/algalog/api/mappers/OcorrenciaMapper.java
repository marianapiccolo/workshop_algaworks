package com.algaworks.algalog.api.mappers;

import com.algaworks.algalog.api.resources.OcorrenciaResource;
import com.algaworks.algalog.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {
	
	private ModelMapper modelMapper;

    public Collection<OcorrenciaResource> toCollection(Collection<Ocorrencia> ocorrencias) {
        return ocorrencias.stream()
                .map(this::toResource)
                .collect(Collectors.toList());
    }

    public Ocorrencia toEntity(OcorrenciaResource resource) {
        return modelMapper.map(resource, Ocorrencia.class);
    }

    public OcorrenciaResource toResource(Ocorrencia entity) {
        return modelMapper.map(entity, OcorrenciaResource.class);
    }

}
