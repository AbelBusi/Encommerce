package com.Encommerce.repository;

import com.Encommerce.logica.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar
 */
@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer>{
    
    
}
