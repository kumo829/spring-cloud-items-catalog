package com.javatutoriales.springboot.producto.model.dao;

import com.javatutoriales.springboot.producto.model.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {
}
