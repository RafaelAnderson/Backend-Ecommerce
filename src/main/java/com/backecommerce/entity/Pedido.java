package com.backecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class Pedido implements Serializable {
    @Id
    @Column(name = "op")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer op;

    @Column(name = "fecha")
    private ZonedDateTime fecha;

    @Column(name = "numero")
    private String numero;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SELECT)
    private List<PedidoLinea> lineasDePedido = new ArrayList<>();
}
