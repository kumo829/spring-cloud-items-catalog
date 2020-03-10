package com.javatutoriales.springboot.oauthserver.services;

import com.javatutoriales.springboot.commons.usuarios.Usuario;

public interface IUsuarioService {
    Usuario findByUsername(String username);

    Usuario update(Usuario usuario, Long id);
}
