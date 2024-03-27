package com.Encommerce.controlador;

import com.Encommerce.logica.Producto;
import com.Encommerce.logica.Usuario;
import com.Encommerce.service.subirImagen;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import com.Encommerce.service.IProductoService;

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

    @Autowired
    private subirImagen subirImagen;

    @Autowired
    private IProductoService productoService;

    //Se podra ver los productos en el html
    @GetMapping("")
    public String Show(Model productos) {

        productos.addAttribute("productos", productoService.mostrarProductos());
        return "administrador/productos/show.html";

    }

    @GetMapping("/create")
    public String create() {

        return "administrador/productos/create.html";

    }

    @PostMapping("/guardar")
    public String guardar(Producto producto, @RequestParam(name="img") MultipartFile file) throws IOException {

        loggger.info("Este es el objeto de la vista {}", producto);

        //Por mientras se coloca un usuario quemado, ya que la bd pide que esta tabla tenga un usuario tambien
        Usuario usuario = new Usuario(1, "Abel", "", "",
                "", "", "", "ADMIN");
        producto.setUsuario(usuario);

        //Esta validacion se usa cuando se crea un producto
        if (producto.getIdProducto() == null) {

            String nombreImagen = subirImagen.guardarImagenProducto(file);

            producto.setImagenProducto(nombreImagen);
        } else {

        }

        productoService.guardar(producto);
        return "redirect:/producto";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model mostrarProducto) {

        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        loggger.info("Producto buscado {}", producto);
        mostrarProducto.addAttribute("producto", producto);
        return "administrador/productos/edit.html";
    }

    @PostMapping("/actualizar")
    public String actualizar(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            Producto p = new Producto();
            p = productoService.get(producto.getIdProducto()).get();
            producto.setImagenProducto(p.getImagenProducto());
        } else {
            Producto p = new Producto();
            p = productoService.get(producto.getIdProducto()).get();
            //Cuando editamos la imagen

            if (!p.getImagenProducto().equals("default.jpg")) {

                subirImagen.eliminarImagenProducto(p.getImagenProducto());

            }

            String nombreImagen = subirImagen.guardarImagenProducto(file);
            producto.setImagenProducto(nombreImagen);
        }

        productoService.actualizar(producto);
        return "redirect:/producto";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {

        Producto producto = new Producto();
        producto=productoService.get(id).get();
        //Sentencia de eliminar una imagen siempre y cuando no tenga imagen por defecto
        if (!producto.getImagenProducto().equals("default.jpg")) {

            subirImagen.eliminarImagenProducto(producto.getImagenProducto());
        }
        //Optional<Producto> optionalProducto = productoService.get(id);
        //producto = optionalProducto.get();
        productoService.eliminar(id);
        return "redirect:/producto";
    }

}
