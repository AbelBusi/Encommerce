package com.Encommerce.repository;

import com.Encommerce.logica.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar
 */
@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{
    
    
    
    
    
}
