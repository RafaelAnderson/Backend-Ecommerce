package com.backecommerce.dto;

import com.backecommerce.entity.PedidoLinea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoLineaDto {
    private Integer op;
    private String producto;
    private String descripcion;
    private BigDecimal cantidad;
    private BigDecimal precio;
    private BigDecimal importe;

    public PedidoLinea toEntity() {
        PedidoLinea entity = PedidoLinea.builder()
                .op(this.getOp())
                .producto(this.getProducto())
                .descripcion(this.getDescripcion())
                .cantidad(this.getCantidad())
                .precio(this.getPrecio())
                .importe(this.getImporte())
                .build();

        return entity;
    }
}
