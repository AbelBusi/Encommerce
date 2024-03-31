package com.Encommerce.service;

import com.Encommerce.logica.Usuario;
import java.util.Optional;

/**
 *
 * @author cesar
 */

public interface IUsuarioService {
    
    Optional <Usuario> finById(Integer id);
    
    Usuario guardar (Usuario usuario);
    
    Optional<Usuario> findByEmailUsuario(String emailUsuario);    
}
