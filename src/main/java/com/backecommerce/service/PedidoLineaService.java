package com.backecommerce.service;

import com.backecommerce.dto.PedidoLineaDto;

import java.util.List;

public interface PedidoLineaService {
    List<PedidoLineaDto> insert(List<PedidoLineaDto> list);
    List<PedidoLineaDto> update(Integer id, List<PedidoLineaDto> list);
}
