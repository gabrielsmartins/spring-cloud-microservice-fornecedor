package br.com.alura.microservices.fornecedor.mapper;

import br.com.alura.microservices.fornecedor.dto.response.FornecedorResponseDto;
import br.com.alura.microservices.fornecedor.entity.FornecedorEntity;

public class FornecedorMapper {
	
	private FornecedorMapper(){
		
	}

	public static FornecedorResponseDto mapToDto(FornecedorEntity fornecedor) {
		FornecedorResponseDto fornecedorResponseDto = new FornecedorResponseDto();
		fornecedorResponseDto.setBairro(fornecedor.getBairro());
		fornecedorResponseDto.setCEP(fornecedor.getCEP());
		fornecedorResponseDto.setCidade(fornecedor.getCidade());
		fornecedorResponseDto.setComplemento(fornecedor.getComplemento());
		fornecedorResponseDto.setEstado(fornecedor.getEstado());
		fornecedorResponseDto.setId(fornecedor.getId());
		fornecedorResponseDto.setLogradouro(fornecedor.getLogradouro());
		fornecedorResponseDto.setNumero(fornecedor.getNumero());
		return fornecedorResponseDto;
	}

}
