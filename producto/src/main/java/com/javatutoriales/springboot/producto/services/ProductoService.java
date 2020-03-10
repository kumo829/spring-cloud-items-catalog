package com.javatutoriales.springboot.producto.services;

import com.javatutoriales.springboot.producto.model.entity.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> findAll();

    Producto findById(final Long id);

    Producto save(Producto producto);

    void deleteById(Long id);
}
