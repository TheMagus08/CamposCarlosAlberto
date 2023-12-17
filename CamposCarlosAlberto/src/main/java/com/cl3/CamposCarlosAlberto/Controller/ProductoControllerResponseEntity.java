package com.cl3.CamposCarlosAlberto.Controller;


import com.cl3.CamposCarlosAlberto.model.Producto;
import com.cl3.CamposCarlosAlberto.service.ProductoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productoresponseentity")
public class ProductoControllerResponseEntity {

    @Autowired

    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listarProducto(){
        return ResponseEntity.ok(productoService.listarProducto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
        Producto nuevoProducto = productoService.guardarProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Long id){
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Long id, @RequestBody Producto producto){
        producto.setId(id);
        Producto productoActualizado = productoService.actualizarProducto(producto);

        return  productoActualizado!=null? ResponseEntity.ok(productoActualizado):ResponseEntity.notFound().build();
    }

}
