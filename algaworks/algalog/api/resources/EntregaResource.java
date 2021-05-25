package com.algaworks.algalog.api.resources;

import com.algaworks.algalog.domain.model.StatusEntrega;


import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class EntregaResource {
	
	 private ClienteResource cliente;
	 private OffsetDateTime dataFinalizacao;
	 private OffsetDateTime dataPedido;
	 private DestinatarioResource destinatario;
	 private Long id;
	 private StatusEntrega statusEntrega;
	 private BigDecimal taxa;
	public ClienteResource getCliente() {
		return cliente;
	}
	public void setCliente(ClienteResource cliente) {
		this.cliente = cliente;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}
	public DestinatarioResource getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(DestinatarioResource destinatario) {
		this.destinatario = destinatario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StatusEntrega getStatusEntrega() {
		return statusEntrega;
	}
	public void setStatusEntrega(StatusEntrega statusEntrega) {
		this.statusEntrega = statusEntrega;
	}
	public BigDecimal getTaxa() {
		return taxa;
	}
	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	 
	 

}
