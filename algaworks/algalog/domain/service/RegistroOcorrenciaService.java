package com.algaworks.algalog.domain.service;

import org.springframework.transaction.annotation.Transactional;


import com.algaworks.algalog.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
	
	private BuscaEntregaService buscaEntregaService;

    
    @Transactional
    public Ocorrencia registrar(Long idEntrega, String descricao) {
        var entrega = buscaEntregaService.buscar(idEntrega);
        return entrega.adicionarOcorrencia(descricao);
    }

}
