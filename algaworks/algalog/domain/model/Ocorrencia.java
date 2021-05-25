package com.algaworks.algalog.domain.model;


import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ocorrencias")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ocorrencia {
	

    @NotNull
    private OffsetDateTime dataRegistro;
    @NotNull
    private String descricao;
    @ManyToOne
    private Entrega entrega;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
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
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    
    
    
}