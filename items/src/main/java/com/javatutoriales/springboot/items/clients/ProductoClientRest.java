package com.javatutoriales.springboot.items.clients;

import com.javatutoriales.springboot.items.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "servicios.productos")
public interface ProductoClientRest {

    @GetMapping("/listar")
    List<Producto> listar();

    @GetMapping("/listar/{id}")
    Producto detalle(@PathVariable final Long id);

    @PostMapping("/crear")
    Producto crear(@RequestBody Producto producto);

    @PutMapping("/editar/{id}")
    Producto update(@RequestBody Producto producto, @PathVariable Long id);

    @DeleteMapping("/eliminar/{id}")
    void eliminar(@PathVariable Long id);

}
