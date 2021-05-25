package com.algaworks.algalog.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.repository.EntregaRepository;


import lombok.AllArgsConstructor;



import com.algaworks.algalog.domain.repository.EntregaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collection;


@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private final ClienteService clienteService;
	private final EntregaRepository entregaRepository;

    public Collection<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        var clienteEntrega = clienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(clienteEntrega);
        entrega.setStatusEntrega(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.UTC));
        return entregaRepository.save(entrega);
    }
		
		
	}
	


