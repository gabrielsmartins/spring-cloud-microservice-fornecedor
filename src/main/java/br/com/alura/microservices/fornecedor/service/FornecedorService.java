package br.com.alura.microservices.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.fornecedor.entity.FornecedorEntity;
import br.com.alura.microservices.fornecedor.repository.InfoRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private InfoRepository infoRepository;
	
   public FornecedorEntity consultaPorEstado(String estado) {
	   return infoRepository.findByEstado(estado);
   }

}
