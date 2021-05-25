package com.algaworks.algalog.domain.model;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.algaworks.algalog.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Valid
    @ConvertGroup(to = ValidationsGroups.ClienteId.class)
    @NotNull
    @ManyToOne
    private Cliente cliente;

    @Valid
    @NotNull
    @Embedded
    private Destinatario destinatario;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_entrega")
    private StatusEntrega statusEntrega;
    @NotNull
    private BigDecimal taxa;
    @Column(name = "data_pedido")
    private OffsetDateTime dataPedido;
    @Column(name = "data_finalizacao")
    private OffsetDateTime dataFinalizacao;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private Collection<Ocorrencia> ocorrencias;


    public Ocorrencia adicionarOcorrencia(String descricao) {
        var ocorrencia = new Ocorrencia();
        ocorrencia.setDescricao(descricao);
        ocorrencia.setDataRegistro(OffsetDateTime.now());
        ocorrencia.setEntrega(this);
        this.getOcorrencias().add(ocorrencia);

        return ocorrencia;
    }
	

}
