package com.Encommerce.controlador;

import com.Encommerce.logica.Producto;
import com.Encommerce.logica.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Encommerce.service.IProductoService;
import com.Encommerce.service.IUsuarioService;

/**
 *
 * @author cesar
 */
@Controller
@RequestMapping("/administrador")
public class AdministadorController {
    
    @Autowired
    private IProductoService productoService;
    
    @Autowired
    private IUsuarioService IUsuarioService;
    
    @GetMapping("")
    public String home(Model model) {
        
        List<Producto> productos = productoService.mostrarProductos();
        model.addAttribute("productos", productos);
        return "administrador/home.html";
    }
    
    @GetMapping("/verUsuario")
    public String verUusario(Model model){
        
        model.addAttribute("usuario",IUsuarioService.mostrarUsuario());
    
        
        
        return "administrador/usuarios.html";
        
    }
    
}
