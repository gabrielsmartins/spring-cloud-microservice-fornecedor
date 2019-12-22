package br.com.alura.microservices.fornecedor.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.microservices.fornecedor.dto.response.ProdutoResponseDto;
import br.com.alura.microservices.fornecedor.entity.ProdutoEntity;

public class ProdutoMapper {
	
	private ProdutoMapper() {
		
	}

	public static List<ProdutoResponseDto> mapToDto(List<ProdutoEntity> produtos) {
		return produtos
				 .stream()
				 .map(p -> mapToDto(p))
				 .collect(Collectors.toList());
	}
	
	public static ProdutoResponseDto mapToDto(ProdutoEntity produto) {
		ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto();
		produtoResponseDto.setDescricao(produto.getDescricao());
		produtoResponseDto.setEstado(produto.getEstado());
		produtoResponseDto.setId(produto.getId());
		produtoResponseDto.setNome(produto.getNome());
		produtoResponseDto.setPreco(produto.getPreco());
		return produtoResponseDto;
	}

}
