package com.Encommerce.service;

import com.Encommerce.logica.DetalleOrden;
import com.Encommerce.logica.Pedido;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author cesar
 */
public interface IDetalleOrdenService {
    
    DetalleOrden save (DetalleOrden detalleOrden);
    
    List<DetalleOrden> mostrarIdPedido(Pedido pedido);
    
    Optional<DetalleOrden> get(Integer id);
    
}
