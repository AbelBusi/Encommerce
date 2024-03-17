package com.Encommerce.service;

import com.Encommerce.logica.Producto;
import com.Encommerce.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
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
