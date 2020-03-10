package com.javatutoriales.springboot.producto.controllers;

import com.javatutoriales.springboot.producto.model.entity.Producto;
import com.javatutoriales.springboot.producto.services.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductoController {

    private final ProductoService productoService;
    //private final Environment env;//Una forma de obtener el puerto es con env.getProperty("local.server.port")

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll().stream().map(p -> {
            p.setPuerto(getPuerto());
            return p;
        }).collect(Collectors.toList());
    }

    @GetMapping("/listar/{id}")
    public Producto detalle(@PathVariable final Long id) {

        Producto producto = productoService.findById(id);
        producto.setPuerto(getPuerto());

        boolean ok = false;

        //region Error para probar Hystrix
       /* if(ok == false){
            throw new RuntimeException("No se pudo cargar el producto");
        }*/
        //endregion

        //region Pausa para probar el timeout
     /*  try {
           Thread.sleep(2000L);
       }catch (InterruptedException e){
           e.printStackTrace();
       }*/
        //endregion

        return producto;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
        Producto productoDB = productoService.findById(id);

        productoDB.setNombre(producto.getNombre());
        productoDB.setPrecio(producto.getPrecio());

        return productoService.save(productoDB);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        productoService.deleteById(id);
    }

    private Integer getPuerto() {
        return port;
    }
}
