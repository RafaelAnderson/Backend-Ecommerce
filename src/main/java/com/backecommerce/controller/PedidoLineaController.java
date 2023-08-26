package com.backecommerce.controller;

import com.backecommerce.dto.PedidoLineaDto;
import com.backecommerce.service.PedidoLineaService;
import com.backecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido_linea")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoLineaController {
    @Autowired
    PedidoLineaService pedidoLineaService;
    @PostMapping(path = "/insertar")
    public ResponseEntity<ApiResponse> insertar(@RequestBody List<PedidoLineaDto> list) {
        pedidoLineaService.insert(list);
        return ResponseEntity.ok(ApiResponse.ok("Pedido agregado ", list));
    }
    @PutMapping(path = "/actualizar/{id}")
    public ResponseEntity<ApiResponse> actualizar(@PathVariable("id") Integer id, @RequestBody List<PedidoLineaDto> list) {
        pedidoLineaService.update(id, list);
        return ResponseEntity.ok(ApiResponse.ok("Listado de pedidos actualizado ", list));
    }
}
