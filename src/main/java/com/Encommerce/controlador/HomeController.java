package com.Encommerce.controlador;

import com.Encommerce.logica.Producto;
import com.Encommerce.service.ProductoService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    private final Logger loggger = LoggerFactory.getLogger(ProductoController.class);

    @GetMapping("/")
    public String home(Model producto) {

        producto.addAttribute("productos", productoService.mostrarProductos());

        return "administrador/usuario/homeUsuario.html";
    }

    @GetMapping("verProducto/{id}")
    public String verProducto(@PathVariable Integer id, Model verProducto) {

        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        loggger.info("Producto buscado {}", producto);
        verProducto.addAttribute("producto", producto);
        
        return "administrador/usuario/productoHome.html";
    }

}
