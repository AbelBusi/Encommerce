package com.Encommerce.controlador;

import com.Encommerce.logica.Pedido;
import com.Encommerce.logica.Usuario;
import com.Encommerce.service.IDetalleOrdenService;
import com.Encommerce.service.IPedidoService;
import com.Encommerce.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private IPedidoService iPedidoService;

    @Autowired
    private IDetalleOrdenService IDetalleOrdenService;
    
    BCryptPasswordEncoder passEncode = new BCryptPasswordEncoder();

    //Pedido pedido = new Pedido();
    @GetMapping("/registro")
    public String registroUsuario() {

        return "administrador/usuario/registro.html";

    }

    @PostMapping("/usuarioGuardado")
    public String guardarUsuario(Usuario usuario) {
        usuario.setTipoUsuario("USER");
        usuario.setNickUsuario("BLAST 24");
        usuario.setPasswordUsuario(passEncode.encode(usuario.getPasswordUsuario()));
        loggger.info("El usuario es {}", usuario);

        usuarioService.guardar(usuario);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginUsuario() {

        return "administrador/usuario/login.html";

    }

    //Validacion oara saber si un usario existe en la bd
    @PostMapping("/accederUsuario")
    public String accederUsuario(Usuario usuario, HttpSession session) {

        loggger.info("Accesos: {}", usuario);

        Optional<Usuario> user = usuarioService.findByEmailUsuario(usuario.getEmailUsuario());
        //loggger.info("Usuario de db: {}",user.get());

        if (user.isPresent()) {

            session.setAttribute("idUsuario", user.get().getIdUsuario());
            if (user.get().getTipoUsuario().equals("ADMIN")) {

                return "redirect:/administrador";
            } else {

                return "redirect:/";
            }

        } else {

            loggger.info("El usuario no existe");

        }
        return "redirect:/";
    }

    @GetMapping("/verCompra")
    public String verCompra(Model model, HttpSession session) {
        model.addAttribute("sesion", session.getAttribute("idUsuario"));

        Usuario usuario = usuarioService.finById(Integer.parseInt(session.getAttribute("idUsuario").toString())).get();
        List<Pedido> pedidos = iPedidoService.mostrarPedidoIdUsuario(usuario);
        model.addAttribute("pedido", pedidos);

        return "administrador/usuario/compras.html";

    }

    @GetMapping("/detalleCompra/{idPedido}")
    public String detalleCompra(Model model, HttpSession session, @PathVariable Integer idPedido) {

        loggger.info("id {}", idPedido);
        model.addAttribute("sesion", session.getAttribute("idUsuario"));
        
        Optional <Pedido> pedido=iPedidoService.finById(idPedido);
        
        model.addAttribute("detalles",pedido.get().getDetalleOrden());
        return "administrador/usuario/detallecompra.html";

    }
    
    @GetMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession session){
        
        session.removeAttribute("idUsuario");
        
        return "redirect:/";
        
    }

}
