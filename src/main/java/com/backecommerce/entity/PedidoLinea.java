package com.backecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido_linea")
public class PedidoLinea {
    @Id
    @Column(name = "op")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer op;

    @ManyToOne
    @JoinColumn(name = "numero", nullable = false)
    private Pedido pedido;

    @Column(name = "producto")
    private String producto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private BigDecimal cantidad;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "importe")
    private BigDecimal importe;
}
