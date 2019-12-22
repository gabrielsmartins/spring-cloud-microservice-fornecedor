package br.com.alura.microservices.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.fornecedor.dto.request.ItemPedidoRequestDto;
import br.com.alura.microservices.fornecedor.entity.ItemPedidoEntity;
import br.com.alura.microservices.fornecedor.entity.PedidoEntity;
import br.com.alura.microservices.fornecedor.entity.ProdutoEntity;
import br.com.alura.microservices.fornecedor.repository.PedidoRepository;
import br.com.alura.microservices.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public PedidoEntity realizaPedido(List<ItemPedidoRequestDto> itens) {
		
		if(itens == null) {
			return null;
		}
		
		List<ItemPedidoEntity> pedidoItens = toPedidoItem(itens);
		PedidoEntity pedido = new PedidoEntity(pedidoItens);
		pedido.setTempoDePreparo(itens.size());
		return pedidoRepository.save(pedido);
	}
	
	public PedidoEntity getPedidoPorId(Long id) {
		return this.pedidoRepository.findById(id).orElse(new PedidoEntity());
	}

	private List<ItemPedidoEntity> toPedidoItem(List<ItemPedidoRequestDto> itens) {
		
		List<Long> idsProdutos = itens
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<ProdutoEntity> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);
		
		List<ItemPedidoEntity> pedidoItens = itens
			.stream()
			.map(item -> {
				ProdutoEntity produto = produtosDoPedido
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();
				
				ItemPedidoEntity pedidoItem = new ItemPedidoEntity();
				pedidoItem.setProduto(produto);
				pedidoItem.setQuantidade(item.getQuantidade());
				return pedidoItem;
			})
			.collect(Collectors.toList());
		return pedidoItens;
	}
}
