package br.com.alura.microservices.fornecedor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.microservices.fornecedor.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long>{

	public List<ProdutoEntity> findByEstado(String estado);
	
	public List<ProdutoEntity> findByIdIn(List<Long> ids);
}
