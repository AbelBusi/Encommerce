package com.Encommerce.service;

import com.Encommerce.logica.Pedido;
import com.Encommerce.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoRepository iPedidoRepository;

    @Override
    public Pedido save(Pedido pedido) {
        return iPedidoRepository.save(pedido);
    }

}
