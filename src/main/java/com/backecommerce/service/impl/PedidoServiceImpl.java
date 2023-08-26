package com.backecommerce.service.impl;

import com.backecommerce.dao.PedidoDao;
import com.backecommerce.dao.PedidoLineaDao;
import com.backecommerce.dto.PedidoDto;
import com.backecommerce.dto.PedidoLineaDto;
import com.backecommerce.entity.Pedido;
import com.backecommerce.entity.PedidoLinea;
import com.backecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    PedidoDao pedidoDao;
    @Autowired
    PedidoLineaDao pedidoLineaDao;

    @Override
    public List<PedidoDto> getList() {
        List<Pedido> list = pedidoDao.findAll();
        List<PedidoDto> dtoList = new ArrayList<>();
        for (Pedido pedido : list) {
            PedidoDto dto = new PedidoDto();
            dto.setOp(pedido.getOp());
            dto.setFecha(pedido.getFecha());
            dto.setNumero(pedido.getNumero());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public PedidoDto getPedido(Integer id) {
        Optional<Pedido> optionalPedido = pedidoDao.findById(id);

        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            return convertToDto(pedido);
        }
        return null;
    }

    private PedidoDto convertToDto(Pedido pedido) {
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setOp(pedido.getOp());
        pedidoDto.setFecha(pedido.getFecha());
        pedidoDto.setNumero(pedido.getNumero());

        List<PedidoLineaDto> lineasDto = new ArrayList<>();
        for (PedidoLinea linea : pedido.getLineasDePedido()) {
            PedidoLineaDto lineaDto = new PedidoLineaDto();
            lineaDto.setOp(linea.getOp());
            lineaDto.setProducto(linea.getProducto());
            lineaDto.setDescripcion(linea.getDescripcion());
            lineaDto.setCantidad(linea.getCantidad());
            lineaDto.setPrecio(linea.getPrecio());
            lineaDto.setImporte(linea.getImporte());
            lineasDto.add(lineaDto);
        }
        pedidoDto.setPedidoLineaDtoList(lineasDto);

        return pedidoDto;
    }

    @Override
    public void delete(Integer id) {
        Optional<Pedido> optionalPedido = pedidoDao.findById(id);

        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            List<PedidoLinea> pedidoLinea = pedido.getLineasDePedido();
            pedidoLinea.forEach(item -> pedidoLineaDao.delete(item));
            pedidoDao.delete(pedido);
        }
    }
}
