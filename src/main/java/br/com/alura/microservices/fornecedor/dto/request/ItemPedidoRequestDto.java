package br.com.alura.microservices.fornecedor.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemPedidoRequestDto {

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("quantidade")
	private int quantidade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
