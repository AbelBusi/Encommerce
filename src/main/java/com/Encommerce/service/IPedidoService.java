package com.Encommerce.service;

import com.Encommerce.logica.Pedido;
import com.Encommerce.logica.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author cesar
 */
public interface IPedidoService {
    
    Pedido save(Pedido pedido);
    
    List<Pedido> findAll();
    
    String generarNumeroPedido();
    
    List<Pedido> mostrarPedidoIdUsuario(Usuario usuario);
    
    Optional<Pedido> finById(Integer id);
    
    
    
}
