package com.backecommerce.service.impl;

import com.backecommerce.dao.PedidoDao;
import com.backecommerce.dao.PedidoLineaDao;
import com.backecommerce.dto.PedidoLineaDto;
import com.backecommerce.entity.Pedido;
import com.backecommerce.entity.PedidoLinea;
import com.backecommerce.service.PedidoLineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@Transactional
public class PedidoLineaServiceImpl implements PedidoLineaService {
    @Autowired
    PedidoDao pedidoDao;
    @Autowired
    PedidoLineaDao pedidoLineaDao;

    @Override
    public List<PedidoLineaDto> insert(List<PedidoLineaDto> list) {
        ZonedDateTime fechaActual = ZonedDateTime.now();

        Pedido pedido = Pedido.builder().fecha(fechaActual).build();

        pedidoDao.save(pedido);

        Integer opGenerado = pedido.getOp();
        String numeroGenerado = String.format("%08d", opGenerado);
        pedido.setNumero(numeroGenerado);
        pedidoDao.save(pedido);

        list.forEach(registro -> {
            PedidoLinea item = PedidoLinea.builder()
                    .pedido(pedido)
                    .producto(registro.getProducto())
                    .descripcion(registro.getDescripcion())
                    .cantidad(registro.getCantidad())
                    .precio(registro.getPrecio())
                    .importe(registro.getImporte())
                    .build();
            pedidoLineaDao.save(item);
        });

        return list;
    }

    @Override
    public List<PedidoLineaDto> update(Integer op, List<PedidoLineaDto> list) {
        pedidoLineaDao.deleteByPedidoOp(op);

        Pedido pedido = pedidoDao.findById(op).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        list.forEach(registro -> {
            PedidoLinea item = PedidoLinea.builder()
                    .pedido(pedido)
                    .producto(registro.getProducto())
                    .descripcion(registro.getDescripcion())
                    .cantidad(registro.getCantidad())
                    .precio(registro.getPrecio())
                    .importe(registro.getImporte())
                    .build();
            pedidoLineaDao.save(item);
        });
        return list;
    }
}
