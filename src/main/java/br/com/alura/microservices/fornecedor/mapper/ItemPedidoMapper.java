package br.com.alura.microservices.fornecedor.mapper;

import br.com.alura.microservices.fornecedor.dto.response.ItemPedidoResponseDto;
import br.com.alura.microservices.fornecedor.entity.ItemPedidoEntity;

public class ItemPedidoMapper {
	
	private ItemPedidoMapper() {
		
	}

	public static ItemPedidoResponseDto mapToDto(ItemPedidoEntity itemEntity) {
		ItemPedidoResponseDto itemPedidoResponseDto = new ItemPedidoResponseDto();
		itemPedidoResponseDto.setId(itemEntity.getId());
		itemPedidoResponseDto.setQuantidade(itemEntity.getQuantidade());
		return itemPedidoResponseDto;
	}
}
