package com.Encommerce.service;

import com.Encommerce.logica.Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author cesar
 */

public interface ProductoService {
    
    public Producto guardar(Producto producto);
    public Optional<Producto> get(Integer id);
    public void actualizar(Producto producto);
    public void eliminar(Integer id);
    public List<Producto> mostrarProductos();
    
}
