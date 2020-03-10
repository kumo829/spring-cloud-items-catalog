package com.javatutoriales.springboot.oauthserver.security.event;

import com.javatutoriales.springboot.commons.usuarios.Usuario;
import com.javatutoriales.springboot.oauthserver.services.IUsuarioService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

    private final IUsuarioService usuarioService;

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("Success Login");
        log.info(userDetails.getUsername());

        Usuario usuario = usuarioService.findByUsername(authentication.getName());

        if (usuario.getIntentos() != null && usuario.getIntentos() != 0) {
            usuario.setIntentos(0);
            usuarioService.update(usuario, usuario.getId());
        }
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
        System.out.println("Error en autenticación: " + exception.getMessage());

        try {
            Usuario usuario = usuarioService.findByUsername(authentication.getName());
            if (usuario.getIntentos() == null) {
                usuario.setIntentos(0);
            }

            usuario.setIntentos(usuario.getIntentos() + 1);
            log.info("Intentos actual es de {}", usuario.getIntentos());

            if (usuario.getIntentos() >= 3) {
                log.error("Usuario {} deshabilitado por maximos intentos", usuario.getNombre());
                usuario.setEnabled(false);
            }

            usuarioService.update(usuario, usuario.getId());
        } catch (FeignException e) {
            log.error(String.format("El usuario %s no existe en el sistema", authentication.getName()));
        }
    }
}
