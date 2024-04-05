package com.Encommerce.controlador;

import com.Encommerce.logica.Pedido;
import com.Encommerce.logica.Producto;
import com.Encommerce.service.IPedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Encommerce.service.IProductoService;
import com.Encommerce.service.IUsuarioService;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private IPedidoService PedidoService;

    @GetMapping("")
    public String home(Model model) {

        List<Producto> productos = productoService.mostrarProductos();
        model.addAttribute("productos", productos);
        return "administrador/home.html";
    }

    @GetMapping("/verUsuario")
    public String verUusario(Model model) {

        model.addAttribute("usuario", IUsuarioService.mostrarUsuario());

        return "administrador/usuarios.html";

    }

    @GetMapping("/verPedido")
    public String verPedido(Model model) {

        model.addAttribute("pedido", PedidoService.findAll());

        return "administrador/compras.html";

    }

    @GetMapping("/detalleCompra/{idPedido}")
    public String detalleCompra(Model model, @PathVariable Integer idPedido) {

        Optional<Pedido> pedido = PedidoService.finById(idPedido);

        model.addAttribute("detalles", pedido.get().getDetalleOrden());
        return "administrador/detallecompra.html";

    }

    @PostMapping("/buscarProducto")
    public String buscarProducto(@RequestParam String nombreProducto, Model model) {

        //Creando la funcion para buscar o filtrar
        String searchTerm = nombreProducto.toLowerCase(Locale.ITALY);

        // Filtra la lista de productos
        List<Producto> productos = productoService.mostrarProductos().stream()
                .filter(p -> {
                    String productName = p.getNombreProducto().toLowerCase(Locale.ITALY);
                    return productName.startsWith(searchTerm) || productName.endsWith(searchTerm) || productName.contains(searchTerm);
                })
                .collect(Collectors.toList());
        model.addAttribute("productos", productos);

        return "administrador/home.html";
    }

}
