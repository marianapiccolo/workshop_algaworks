package com.algaworks.algalog.domain.service;


import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class BuscaEntregaService {
	
	private EntregaRepository entregaRepository;

    public Entrega buscar(Long idEntrega) {
        return entregaRepository
                .findById(idEntrega).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada!"));
    }

}
