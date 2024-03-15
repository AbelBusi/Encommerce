package com.Encommerce.service;

import com.Encommerce.logica.Producto;
import java.util.Optional;

/**
 *
 * @author cesar
 */

public interface ProductoService {
    
    public Producto guardar(Producto producto);
    public Optional<Producto> get(int id);
    public void actualizar(Producto producto);
    public void eliminar(int id);
    
}
