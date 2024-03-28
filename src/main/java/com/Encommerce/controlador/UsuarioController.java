package com.Encommerce.controlador;

import com.Encommerce.logica.Usuario;
import com.Encommerce.service.IUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cesar
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final Logger loggger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/registro")
    public String registroUsuario() {

        return "administrador/usuario/registro.html";

    }

    @PostMapping("/usuarioGuardado")
    public String guardarUsuario(Usuario usuario) {
        usuario.setTipoUsuario("USER");
        usuario.setNickUsuario("BLAST 24");
        loggger.info("El usuario es {}", usuario);

        usuarioService.guardar(usuario);

        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String loginUsuario(){
    
        return "administrador/usuario/login.html";
        
    }
    
    @PostMapping("/accederUsuario")
    public String accederUsuario(Usuario usuario){
        
        loggger.info("Accesos: {}",usuario);
        
        return "redirect:/";
    }

}
