package com.Encommerce.repository;

import com.Encommerce.logica.DetalleOrden;
import com.Encommerce.logica.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar
 */
@Repository
public interface IDetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer>{
    
    List<DetalleOrden> findByPedido(Pedido pedido);
    
}
