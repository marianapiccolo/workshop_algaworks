package com.algaworks.algalog.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {
	
    public EntidadeNaoEncontradaException(String ocorrenciaDaOperacao) {
        super(ocorrenciaDaOperacao);
    }

}
