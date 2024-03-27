package com.Encommerce.controlador;

import com.Encommerce.logica.DetalleOrden;
import com.Encommerce.logica.Pedido;
import com.Encommerce.logica.Producto;
import com.Encommerce.logica.Usuario;
import com.Encommerce.service.IDetalleOrdenService;
import com.Encommerce.service.IPedidoService;
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
import com.Encommerce.service.IProductoService;
import com.Encommerce.service.IUsuarioService;
import com.Encommerce.service.UsuarioServiceImpl;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 *
 * @author cesar
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IUsuarioService iUsuarioService;

    @Autowired
    private IPedidoService iPedidoService;

    @Autowired
    private IDetalleOrdenService iDetalleOrdenService;

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
    public String addCarrito(@RequestParam Integer idProducto, @RequestParam Integer cantidad, Model model) {

        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = new Producto();
        double sumaTotal = 0;
        Optional<Producto> optionalProducto = productoService.get(idProducto);
        loggger.info("Producto añadido {}", optionalProducto.get());
        loggger.info("cantidad: {}", cantidad);

        producto = optionalProducto.get();
        detalleOrden.setCantidadOrden(cantidad);
        detalleOrden.setPrecioOrden(producto.getPrecioProducto());
        detalleOrden.setNombreDetalleOrden(producto.getNombreProducto());
        detalleOrden.setTotalOrden(producto.getPrecioProducto() * cantidad);
        detalleOrden.setProducto(producto);

        //Validacion para que el producto no se sobrecargue muchas veces
        Integer idproducto = producto.getIdProducto();

        boolean ingresar = detalles.stream().anyMatch(p -> p.getProducto().getIdProducto() == idproducto);
        if (!ingresar) {

            detalles.add(detalleOrden);

        }

        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotalOrden()).sum();
        pedido.setTotalPedido(sumaTotal);
        model.addAttribute("carrito", detalles);
        model.addAttribute("pedido", pedido);

        return "administrador/usuario/carrito.html";
    }

    @GetMapping("/delete/carrito/{id}")
    public String eliminarProductoCart(@PathVariable Integer id, Model model) {

        //Lista de los productos
        List<DetalleOrden> ordenNueva = new ArrayList<DetalleOrden>();

        for (DetalleOrden detalleOrden : detalles) {

            if (detalleOrden.getProducto().getIdProducto() != id) {
                ordenNueva.add(detalleOrden);
            }

        }

        //Poner la nueva lista con los productos restantes
        detalles = ordenNueva;

        double sumaTotal = 0;
        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotalOrden()).sum();
        pedido.setTotalPedido(sumaTotal);
        model.addAttribute("carrito", detalles);
        model.addAttribute("pedido", pedido);

        return "administrador/usuario/carrito.html";
    }

    @GetMapping("/getCart")
    public String getCart(Model model) {

        model.addAttribute("carrito", detalles);
        model.addAttribute("pedido", pedido);

        return "administrador/usuario/carrito.html";
    }

    @GetMapping("/OrdenResumen")
    public String resumenOrden(Model model) {

        Usuario usuario = iUsuarioService.finById(1).get();

        model.addAttribute("carrito", detalles);
        model.addAttribute("pedido", pedido);
        model.addAttribute("usuario", usuario);

        return "administrador/usuario/resumenOrden.html";

    }
    
    @GetMapping("/guardarPedido")
    public String guardarPedido(){
        
        Date fechaPedido = new Date();
        pedido.setFechaCreacionPedido(fechaPedido);
        pedido.setNumeroPedido(iPedidoService.generarNumeroPedido());
    
        Usuario usuario =iUsuarioService.finById(1).get();
        pedido.setUsuario(usuario);
        iPedidoService.save(pedido);
        
        //Guadar los detalles del pedido
        for (DetalleOrden dt:detalles){
            
            dt.setPedido(pedido);
            iDetalleOrdenService.save(dt);
        
        }
        
        //Refrescar la lista y los pedidos
        Pedido pedido= new Pedido();
        detalles.clear();
        
        return "redirect:/";
        
    }
    
    @PostMapping("/buscarProducto")
    public String buscarProducto(@RequestParam String nombreProducto,Model model){
        
        loggger.info("Nombre del producto: {}",nombreProducto);
        //Creando la funcion para buscar o filtrar
        List<Producto> productos =productoService.mostrarProductos().stream().filter(p -> p.getNombreProducto().contains(nombreProducto.toLowerCase(Locale.ITALY))).collect(Collectors.toList());
        model.addAttribute("productos",productos);
    
        return "administrador/usuario/homeUsuario.html";
    }

}
