package com.Encommerce.service;

import com.Encommerce.logica.Pedido;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface IPedidoService {
    
    Pedido save(Pedido pedido);
    
    List<Pedido> findAll();
    
    String generarNumeroPedido();
    
}
