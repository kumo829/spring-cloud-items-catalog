package com.javatutoriales.springboot.usuarioservicio.config;

import com.javatutoriales.springboot.commons.usuarios.Rol;
import com.javatutoriales.springboot.commons.usuarios.Usuario;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Usuario.class, Rol.class);
    }
}
