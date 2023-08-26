package com.backecommerce.dto;

import com.backecommerce.entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    private Integer op;
    private ZonedDateTime fecha;
    private String numero;
    private List<PedidoLineaDto> pedidoLineaDtoList = null;
    private Pedido toEntity() {
        Pedido entity = Pedido.builder()
                .op(this.getOp())
                .fecha(this.fecha)
                .numero(this.numero)
                .build();

        if(getPedidoLineaDtoList() != null) {
            getPedidoLineaDtoList().forEach(item -> {
                entity.getLineasDePedido().add(item.toEntity());
            });
        }
        return entity;
    }
}
