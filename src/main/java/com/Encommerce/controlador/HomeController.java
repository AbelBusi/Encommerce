package com.Encommerce.controlador;

import com.Encommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cesar
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String home(Model producto) {

        producto.addAttribute("productos", productoService.mostrarProductos());

        return "administrador/usuario/homeUsuario.html";
    }

}
