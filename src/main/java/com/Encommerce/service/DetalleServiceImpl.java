package com.Encommerce.service;

import com.Encommerce.logica.DetalleOrden;
import com.Encommerce.repository.IDetalleOrdenRepository;
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
    
}
