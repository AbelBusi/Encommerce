package com.Encommerce.service;

import com.Encommerce.logica.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Encommerce.repository.IProductoRepository;

/**
 *
 * @author cesar
 */
@Service
public class ProductoServiceImpl implements IProductoService {
    
    @Autowired
    private IProductoRepository productoRepository;
    
    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }
    
    @Override
    public Optional<Producto> get(Integer id) {
        return productoRepository.findById(id);
    }
    
    @Override
    public void actualizar(Producto producto) {
        
        productoRepository.save(producto);
        
    }
    
    @Override
    public void eliminar(Integer id) {
        
        productoRepository.deleteById(id);
        
    }

    @Override
    public List<Producto> mostrarProductos() {
        return productoRepository.findAll();
    }
    
}
