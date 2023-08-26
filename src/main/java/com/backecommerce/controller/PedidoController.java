package com.backecommerce.controller;

import com.backecommerce.dto.PedidoDto;
import com.backecommerce.entity.Pedido;
import com.backecommerce.service.PedidoService;
import com.backecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/pedido")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;
    @GetMapping(path = "/listar")
    public ResponseEntity<ApiResponse> listar() {
        List<PedidoDto> list = pedidoService.getList();
        return ResponseEntity.ok(ApiResponse.ok("Listado de pedidos ", list));
    }
    @GetMapping(path = "/listarPedido/{id}")
    public ResponseEntity<ApiResponse> listarPedido(@PathVariable("id") Integer id) {
        PedidoDto pedido = pedidoService.getPedido(id);
        return ResponseEntity.ok(ApiResponse.ok("Pedido", pedido));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ApiResponse> eliminar(@PathVariable("id") Integer id) {
        pedidoService.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Pedido eliminado correctamente ", id));
    }
}
