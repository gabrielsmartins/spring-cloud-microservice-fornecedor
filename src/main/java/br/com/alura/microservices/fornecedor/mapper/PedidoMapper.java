package br.com.alura.microservices.fornecedor.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.microservices.fornecedor.dto.response.ItemPedidoResponseDto;
import br.com.alura.microservices.fornecedor.dto.response.PedidoResponseDto;
import br.com.alura.microservices.fornecedor.entity.PedidoEntity;

public class PedidoMapper {

	private PedidoMapper() {
		
	}
	
	public static PedidoResponseDto mapToDto(PedidoEntity pedidoEntity) {
		PedidoResponseDto pedidoResponseDto = new PedidoResponseDto();
		pedidoResponseDto.setId(pedidoEntity.getId());
		List<ItemPedidoResponseDto> itensDto = pedidoEntity.getItens()
		              .stream()
		              .map(item -> ItemPedidoMapper.mapToDto(item))
		              .collect(Collectors.toList());
		pedidoResponseDto.setItens(itensDto);
		pedidoResponseDto.setStatus(pedidoEntity.getStatus().toString());
		pedidoResponseDto.setTempoDePreparo(pedidoEntity.getTempoDePreparo());
		return pedidoResponseDto;
	}
	
	
}
