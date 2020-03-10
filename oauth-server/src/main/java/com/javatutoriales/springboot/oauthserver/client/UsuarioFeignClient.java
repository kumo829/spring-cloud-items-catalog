package com.javatutoriales.springboot.oauthserver.client;

import com.javatutoriales.springboot.commons.usuarios.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "servcio-usuarios")
public interface UsuarioFeignClient {
    @GetMapping("/usuarios/search/find-username")
    public Usuario findByUsername(@RequestParam String username);

    @PutMapping("/usuarios/{id}")
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id);
}
