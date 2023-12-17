package com.cl3.CamposCarlosAlberto.service.impl;

import com.cl3.CamposCarlosAlberto.model.Producto;
import com.cl3.CamposCarlosAlberto.repository.ProductoRepository;
import com.cl3.CamposCarlosAlberto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public Producto guardarProducto(Producto producto) {
        validarProducto(producto);
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        validarProducto(producto);
        if (!productoRepository.existsById(producto.getId())){
            throw new IllegalArgumentException("El producto no existe");
        }
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> listarProducto() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public void eliminarProducto(Long id) {
        if(!productoRepository.existsById(id)){
            throw new IllegalArgumentException("El producto no existe");
        }
        productoRepository.deleteById(id);
    }

    private void validarProducto(Producto producto) {
        if(producto.getDescription()==null || producto.getDescription().isEmpty()){
            throw new IllegalArgumentException("La descripcion es obligatoria");
        }
    }
}
