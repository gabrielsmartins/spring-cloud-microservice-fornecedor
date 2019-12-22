package br.com.alura.microservices.fornecedor.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservaResponseDto {

	@JsonProperty("id")
	public Integer idReserva;
	
	@JsonProperty("tempo_preparo")
	public Integer tempoDePreparo;

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}
	
}
