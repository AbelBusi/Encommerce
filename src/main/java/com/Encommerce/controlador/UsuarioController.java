package com.Encommerce.controlador;

import com.Encommerce.logica.Usuario;
import com.Encommerce.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;
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
    
    //Validacion oara saber si un usario existe en la bd
    @PostMapping("/accederUsuario")
    public String accederUsuario(Usuario usuario, HttpSession session){
        
        loggger.info("Accesos: {}",usuario);
        
        Optional<Usuario> user=usuarioService.findByEmailUsuario(usuario.getEmailUsuario());
        //loggger.info("Usuario de db: {}",user.get());
        
        if (user.isPresent()){
            
            session.setAttribute("idUsuario", user.get().getIdUsuario());
            if(user.get().getTipoUsuario().equals("ADMIN")){
                
                return "redirect:/administrador";
            }else{
            
                return "redirect:/";
            }
        
        }else{
            
            loggger.info("El usuario no existe");
        
            
        }
        return "redirect:/";
    }

}
