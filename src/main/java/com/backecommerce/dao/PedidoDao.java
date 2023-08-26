package com.backecommerce.dao;

import com.backecommerce.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDao extends JpaRepository<Pedido, Integer> {
}
