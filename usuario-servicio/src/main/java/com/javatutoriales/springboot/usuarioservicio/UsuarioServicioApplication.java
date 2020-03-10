package com.javatutoriales.springboot.usuarioservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"com.javatutoriales.springboot.commons.usuarios"})
@SpringBootApplication
public class UsuarioServicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsuarioServicioApplication.class, args);
    }

}
