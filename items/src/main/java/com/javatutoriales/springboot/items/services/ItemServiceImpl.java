package com.javatutoriales.springboot.items.services;

import com.javatutoriales.springboot.items.models.Item;
import com.javatutoriales.springboot.items.models.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//En este clase se usa un RestTemplate para llamar al servicio de productos, en la clase ItemServiceFeignClient se muestra una forma alternativa a través de Feign
@Service("itemServiceRest")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemServiceImpl implements ItemService {

    public static final String ID = "id";
    public static final String BASE_URL = "http://servicios.productos";
    private final RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(restTemplate.getForObject(BASE_URL + "/listar", Producto[].class));
        return productos.parallelStream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> params = new HashMap<>();
        params.put(ID, id.toString());
        Producto producto = restTemplate.getForObject(BASE_URL + "/listar/{id}", Producto.class, params);
        return new Item(producto, cantidad);
    }

    @Override
    public Producto save(Producto producto) {
        HttpEntity<Producto> body = new HttpEntity<>(producto);
        ResponseEntity<Producto> response = restTemplate.exchange(BASE_URL + "/crear", HttpMethod.POST, body, Producto.class);

        Producto productoResponse = response.getBody();

        return productoResponse;
    }

    @Override
    public Producto update(Producto producto, Long id) {
        HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
        Map<String, String> params = new HashMap<>();
        params.put(ID, id.toString());

        ResponseEntity<Producto> response = restTemplate.exchange(BASE_URL + "/editar/{id}", HttpMethod.PUT, body, Producto.class, params);

        return response.getBody();
    }

    @Override
    public void delete(Long id) {
        Map<String, String> params = new HashMap<>();
        params.put(ID, id.toString());

        restTemplate.delete(BASE_URL + "/eliminar/{id}", params);
    }
}
