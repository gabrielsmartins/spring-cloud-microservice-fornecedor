package br.com.alura.microservices.fornecedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.fornecedor.dto.FornecedorResponseDto;
import br.com.alura.microservices.fornecedor.entity.FornecedorEntity;
import br.com.alura.microservices.fornecedor.mapper.FornecedorMapper;
import br.com.alura.microservices.fornecedor.service.FornecedorService;

@RestController
@RequestMapping("/info")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("/{estado}")
	public ResponseEntity<FornecedorResponseDto> consultaPorEstado(@PathVariable("estado") String estado){
		FornecedorEntity fornecedor = fornecedorService.consultaPorEstado(estado);
		FornecedorResponseDto fornecedorResponse = FornecedorMapper.mapToDto(fornecedor);
		return new ResponseEntity<FornecedorResponseDto>(fornecedorResponse, HttpStatus.OK);
	}
}
