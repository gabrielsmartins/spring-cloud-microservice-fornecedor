package br.com.alura.microservices.fornecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.fornecedor.dto.request.ItemPedidoRequestDto;
import br.com.alura.microservices.fornecedor.dto.response.PedidoResponseDto;
import br.com.alura.microservices.fornecedor.entity.PedidoEntity;
import br.com.alura.microservices.fornecedor.mapper.PedidoMapper;
import br.com.alura.microservices.fornecedor.service.PedidoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<?>  realizaPedido(@RequestBody List<ItemPedidoRequestDto> itensRequestDto) {
		 PedidoEntity pedido = pedidoService.realizaPedido(itensRequestDto);
		 PedidoResponseDto pedidoResponseDto = PedidoMapper.mapToDto(pedido);
		 return new ResponseEntity<>(pedidoResponseDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPedidoPorId(@PathVariable Long id) {
		 PedidoEntity pedido = pedidoService.getPedidoPorId(id);
		 PedidoResponseDto pedidoResponseDto = PedidoMapper.mapToDto(pedido);
		 return new ResponseEntity<>(pedidoResponseDto, HttpStatus.OK);
	}
}
