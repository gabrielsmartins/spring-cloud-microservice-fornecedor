package br.com.alura.microservices.fornecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.fornecedor.dto.response.ProdutoResponseDto;
import br.com.alura.microservices.fornecedor.entity.ProdutoEntity;
import br.com.alura.microservices.fornecedor.mapper.ProdutoMapper;
import br.com.alura.microservices.fornecedor.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/{estado}")
	public ResponseEntity<?> getProdutosPorEstado(@PathVariable("estado") String estado) {
		 List<ProdutoEntity> produtos = produtoService.getProdutosPorEstado(estado);
		 List<ProdutoResponseDto> produtosResponseDto = ProdutoMapper.mapToDto(produtos);
		 if(produtosResponseDto.isEmpty())
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 return new ResponseEntity<>(produtosResponseDto, HttpStatus.OK);
	}
}
