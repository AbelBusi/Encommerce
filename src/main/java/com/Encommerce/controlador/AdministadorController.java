package com.Encommerce.controlador;

import com.Encommerce.logica.Producto;
import com.Encommerce.service.ProductoService;
import java.util.List;
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
@RequestMapping("/administrador")
public class AdministadorController {

    @Autowired
    private ProductoService productoService;
    
    @GetMapping("")
    public String home(Model model) {

        List<Producto> productos= productoService.mostrarProductos();
        model.addAttribute("productos",productos);
        return "administrador/home.html";
    }

}
