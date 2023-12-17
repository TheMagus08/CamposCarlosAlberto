package com.cl3.CamposCarlosAlberto;

import com.cl3.CamposCarlosAlberto.model.Categoria;
import com.cl3.CamposCarlosAlberto.model.Producto;
import com.cl3.CamposCarlosAlberto.repository.ProductoRepository;
import org.jaxen.expr.iter.IterableAncestorAxis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CamposCarlosAlbertoApplicationTests {

	@Autowired
	private ProductoRepository productoRepository;


	@Test
	void insertarProducto() {

		Producto producto = new Producto();

		//agregar atributos
		producto.setDescription("plato");
		producto.setPrecio(1.0);
		producto.setStock(10);
		producto.setEstado(1);

		//atributos para categoria
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(1L);
		categoria.setDescripcion("cocina");

		producto.setCategoria(categoria);

		Producto productoRegistrado = productoRepository.save(producto);

		assertThat(productoRegistrado).isNotNull();
		assertThat(productoRegistrado.getId()).isGreaterThan(0);
		assertThat(productoRegistrado.getDescription()).isNotEmpty();
		assertThat(productoRegistrado.getPrecio()).isNotNull();
		assertThat(productoRegistrado.getStock()).isNotNull();
		assertThat(productoRegistrado.getStock()).isNotNull();
		assertThat(productoRegistrado.getEstado()).isNotNull();
		assertThat(productoRegistrado.getCategoria()).isNotNull();
		assertThat(productoRegistrado.getCategoria().getIdCategoria()).isGreaterThan(0);
		assertThat(productoRegistrado.getCategoria().getDescripcion()).isNotEmpty();

	}

	@Test
	void actualizarProducto() {

		//editar producto con id

		Producto producto = productoRepository.findById(1L).orElse(null);

		producto.setDescription("platito");
		producto.setPrecio(2.0);
		producto.setStock(9);
		producto.setEstado(1);

		//guardar cambios
		productoRepository.save(producto);

		//verificacion
		Producto productoActualizado = productoRepository.findById(1L).orElse(null);
		assertThat(productoActualizado.getDescription()).isEqualTo("platito");

		assertThat(productoActualizado).isNotNull();
		assertThat(productoActualizado.getId()).isGreaterThan(0);
		assertThat(productoActualizado.getDescription()).isNotEmpty();
		assertThat(productoActualizado.getPrecio()).isNotNull();
		assertThat(productoActualizado.getStock()).isNotNull();
		assertThat(productoActualizado.getStock()).isNotNull();
		assertThat(productoActualizado.getEstado()).isNotNull();
		assertThat(productoActualizado.getCategoria()).isNotNull();
		assertThat(productoActualizado.getCategoria().getIdCategoria()).isGreaterThan(0);
		assertThat(productoActualizado.getCategoria().getDescripcion()).isNotEmpty();



	}


	@Test

	void listarProducto(){
		Iterable<Producto> productos = productoRepository.findAll();
		assertThat(productos).isNotNull();

	}

	@Test
	void eliminarProducto() {
		Long idProductoAEliminar = 1L;

		assertThat(productoRepository.existsById(idProductoAEliminar)).isTrue();

		productoRepository.deleteById(idProductoAEliminar);

		assertThat(productoRepository.existsById(idProductoAEliminar)).isFalse();
	}
}
