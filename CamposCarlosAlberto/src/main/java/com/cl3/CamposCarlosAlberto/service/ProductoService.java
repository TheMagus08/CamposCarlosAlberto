package com.cl3.CamposCarlosAlberto.service;

import com.cl3.CamposCarlosAlberto.model.Producto;
import com.cl3.CamposCarlosAlberto.repository.ProductoRepository;

import java.util.List;

public interface ProductoService {

    Producto guardarProducto(Producto producto);
    Producto actualizarProducto(Producto producto);
    List<Producto> listarProducto();

    void eliminarProducto(Long id);



}
