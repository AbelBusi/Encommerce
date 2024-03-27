package com.Encommerce.repository;

import com.Encommerce.logica.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar
 */
@Repository
public interface IDetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer>{
    
}
