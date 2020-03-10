package com.javatutoriales.springboot.items.services;

import com.javatutoriales.springboot.items.models.Item;
import com.javatutoriales.springboot.items.models.Producto;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findById(Long id, Integer cantidad);

    Producto save(Producto producto);

    Producto update(Producto producto, Long id);

    void delete(Long id);
}
