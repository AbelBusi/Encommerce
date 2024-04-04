package com.Encommerce.service;

import com.Encommerce.logica.Usuario;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    HttpSession session;

    private Logger loggger = LoggerFactory.getLogger(UserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        loggger.info("Este es el username");

        Optional<Usuario> usuarioOptional = usuarioService.findByEmailUsuario(username);

        if (usuarioOptional.isPresent()) {

            loggger.info("Este es el id del usuario {}", usuarioOptional.get().getIdUsuario());
            session.setAttribute("idUsuario", usuarioOptional.get().getIdUsuario());
            Usuario usuarios = usuarioOptional.get();
            BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

            return User.builder().username(usuarios.getNombreUsuario()).password(bCrypt.encode(usuarios.getPasswordUsuario())).roles(usuarios.getTipoUsuario()).build();
        } else {

            throw new UsernameNotFoundException("Uusario no encontrado");

        }

    }

}
