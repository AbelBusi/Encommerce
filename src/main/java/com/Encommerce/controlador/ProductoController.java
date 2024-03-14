 package com.Encommerce.controlador;

import com.Encommerce.logica.Producto;
import com.Encommerce.logica.Usuario;
import com.Encommerce.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cesar
 */
@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    //Creacion de variable logger
    //Es muy importante porque servira para verificar errores, sin necesidad de acudir
    //a un sistem.println (es mas seguro en el ambito laboral)
    private final Logger loggger = LoggerFactory.getLogger(ProductoController.class);
    
    private ProductoService productoService;
    
    @GetMapping("")
    public String Show(){
        
        return "administrador/productos/show.html";
        
    }
    
    @GetMapping("/create")
    public String create(){
        
        return "administrador/productos/create.html";
        
    }
    
    
    @PostMapping("/guardar")
    public String guardar(Producto producto){
    
        loggger.info("Este es el objeto de la vista {}",producto);

        Usuario usuario = new Usuario(1, "Abel", "", "", 
                "", "", "", "ADMIN");
        producto.setUsuario(usuario);
        productoService.guardar(producto);
        return "redirect:/producto";
    }
    
}
