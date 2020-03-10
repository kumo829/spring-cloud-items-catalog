package com.javatutoriales.springboot.items.services;

import com.javatutoriales.springboot.items.clients.ProductoClientRest;
import com.javatutoriales.springboot.items.models.Item;
import com.javatutoriales.springboot.items.models.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
@Primary
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemServiceFeignClient implements ItemService {

    private final ProductoClientRest clientFeign;

    @Override
    public List<Item> findAll() {
        return clientFeign.listar().stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clientFeign.detalle(id), cantidad);
    }

    @Override
    public Producto save(Producto producto) {
        return clientFeign.crear(producto);
    }

    @Override
    public Producto update(Producto producto, Long id) {
        return clientFeign.update(producto, id);
    }

    @Override
    public void delete(Long id) {
        clientFeign.eliminar(id);
    }
}
