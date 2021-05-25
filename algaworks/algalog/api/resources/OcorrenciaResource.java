package com.algaworks.algalog.api.resources;

import java.time.OffsetDateTime;

public class OcorrenciaResource {
	
	 private OffsetDateTime dataRegistro;
	 private String descricao;
	 private Long id;
	public OffsetDateTime getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(OffsetDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	 
	 

}
