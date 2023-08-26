package com.backecommerce.service;

import com.backecommerce.dto.PedidoDto;

import java.util.List;

public interface PedidoService {
    List<PedidoDto> getList();
    PedidoDto getPedido(Integer id);
    void delete(Integer id);
}
