package com.algaworks.algalog.api.controller;


import com.algaworks.algalog.api.mappers.OcorrenciaMapper;
import com.algaworks.algalog.api.resources.OcorrenciaResource;
import com.algaworks.algalog.domain.model.input.OcorrenciaInput;
import com.algaworks.algalog.domain.service.BuscaEntregaService;
import com.algaworks.algalog.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{idEntrega}/ocorrencias")
public class OcorrenciaController {
	
	 private OcorrenciaMapper ocorrenciaMapper;
	    private RegistroOcorrenciaService registroOcorrenciaService;
	    private BuscaEntregaService buscaEntregaService;

	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<OcorrenciaResource> registrar(@PathVariable Long entregaId,
	                                                        @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
	        final var ocorrencia = registroOcorrenciaService
	                .registrar(entregaId, ocorrenciaInput.getDescricao());
	        return ResponseEntity.ok(ocorrenciaMapper.toResource(ocorrencia));
	    }

	    @GetMapping
	    public ResponseEntity<Collection<OcorrenciaResource>> listar(@PathVariable Long idEntrega) {
	        var entrega = buscaEntregaService.buscar(idEntrega);
	        final var ocorrenciaResources = ocorrenciaMapper.toCollection(entrega.getOcorrencias());

	        return ResponseEntity.ok(ocorrenciaResources);
	    }

}
