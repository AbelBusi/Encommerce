package com.Encommerce.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cesar
 */
@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @GetMapping("")
    public String Show(){
        
        return "administrador/productos/show.html";
        
    }
    
    
}
