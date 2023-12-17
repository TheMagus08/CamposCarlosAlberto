package com.cl3.CamposCarlosAlberto.repository;
import com.cl3.CamposCarlosAlberto.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
