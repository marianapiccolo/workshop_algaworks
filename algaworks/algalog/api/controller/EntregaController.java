package com.algaworks.algalog.api.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.mappers.EntregaMapper;
import com.algaworks.algalog.api.model.DestinatarioModel;
import com.algaworks.algalog.api.model.EntregaModel;
import com.algaworks.algalog.api.resources.EntregaResource;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaMapper entregaMapper;
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @GetMapping
    public ResponseEntity<Collection<EntregaResource>> listar() {
        return ResponseEntity.ok(entregaMapper
                .toCollection(solicitacaoEntregaService.listarEntregas()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntregaResource> solicitarEntrega(@Valid @RequestBody EntregaResource entregaResource) {
        final var entrega = solicitacaoEntregaService.solicitar(entregaMapper.toEntity(entregaResource));
        return ResponseEntity.ok(entregaMapper.toResource(entrega));
    }

}
