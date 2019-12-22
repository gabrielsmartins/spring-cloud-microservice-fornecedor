package br.com.alura.microservices.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.microservices.fornecedor.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>{

}
