package com.Encommerce.controlador;

import com.Encommerce.logica.DetalleOrden;
import com.Encommerce.logica.Pedido;
import com.Encommerce.logica.Producto;
import com.Encommerce.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author cesar
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductoService productoService;
    
    //Almacenar el detalle de una orden
    List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    Pedido pedido = new Pedido();
    
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
    
    @PostMapping("/carrito")
    public String addCarrito(@RequestParam Integer idProducto,@RequestParam Integer cantidad, Model model){
    
        DetalleOrden detalleOrden= new DetalleOrden();
        Producto producto = new Producto();
        double sumaTotal=0;
        Optional<Producto> optionalProducto =productoService.get(idProducto);
        loggger.info("Producto añadido {}", optionalProducto.get());
        loggger.info("cantidad: {}",cantidad);
        
        producto=optionalProducto.get();
        detalleOrden.setCantidadOrden(cantidad);
        detalleOrden.setPrecioOrden(producto.getPrecioProducto());
        detalleOrden.setNombreDetalleOrden(producto.getNombreProducto());
        detalleOrden.setTotalOrden(producto.getPrecioProducto()*cantidad);
        detalleOrden.setProducto(producto);
        
        detalles.add(detalleOrden);
        sumaTotal=detalles.stream().mapToDouble(dt ->dt.getTotalOrden()).sum();
        pedido.setTotalPedido(sumaTotal);
        model.addAttribute("carrito",detalles);
        model.addAttribute("pedido",pedido);
        
        return "administrador/usuario/carrito.html";
    }
    

}
