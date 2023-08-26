package com.backecommerce.dao;

import com.backecommerce.entity.PedidoLinea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoLineaDao extends JpaRepository<PedidoLinea, Integer> {
    void deleteByPedidoOp(Integer pedidoOp);
}
