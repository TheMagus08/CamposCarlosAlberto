package com.cl3.CamposCarlosAlberto.Controller;

import com.cl3.CamposCarlosAlberto.model.Producto;
import com.cl3.CamposCarlosAlberto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;



    @GetMapping
    public List<Producto> listarProducto(){
        return productoService.listarProducto();
    }

    @PostMapping
    public Producto guardarProducto(Producto producto){
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public  Producto actualizarProducto(@PathVariable("id") Long id, @RequestBody Producto producto){
        producto.setId(id);
        return  productoService.actualizarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable("id") Long id){
        productoService.eliminarProducto(id);
    }

}
