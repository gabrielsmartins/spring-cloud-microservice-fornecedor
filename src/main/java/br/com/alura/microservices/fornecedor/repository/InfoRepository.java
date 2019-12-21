package br.com.alura.microservices.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservices.fornecedor.entity.FornecedorEntity;

@Repository
public interface InfoRepository extends JpaRepository<FornecedorEntity, Long>{

	public FornecedorEntity findByEstado(String estado);

}
