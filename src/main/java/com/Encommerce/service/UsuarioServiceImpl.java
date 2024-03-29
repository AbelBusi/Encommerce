package com.Encommerce.service;

import com.Encommerce.logica.Usuario;
import com.Encommerce.repository.IUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {
    
    @Autowired
    private IUsuarioRepository IUsuarioRepository;
    
    @Override
    public Optional<Usuario> finById(Integer id) {
        
        return IUsuarioRepository.findById(id);
    }
    
    @Override
    public Usuario guardar(Usuario usuario) {
        
        return IUsuarioRepository.save(usuario);
        
    }
    
    @Override
    public Optional<Usuario> findByEmailUsuario(String emailUsuario) {
        
        return IUsuarioRepository.findByEmailUsuario(emailUsuario);
        
    }
    
}
