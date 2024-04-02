package com.Encommerce.service;

import com.Encommerce.logica.DetalleOrden;
import com.Encommerce.logica.Pedido;
import com.Encommerce.repository.IDetalleOrdenRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
@Service
public class DetalleServiceImpl implements IDetalleOrdenService {

    @Autowired
    private IDetalleOrdenRepository IDetalleOrdenRepository;

    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return IDetalleOrdenRepository.save(detalleOrden);
    }

    @Override
    public List<DetalleOrden> mostrarIdPedido(Pedido pedido) {

        return IDetalleOrdenRepository.findByPedido(pedido);

    }

    @Override
    public Optional<DetalleOrden> get(Integer id) {
        return IDetalleOrdenRepository.findById(id);
    }

}
