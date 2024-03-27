package com.Encommerce.service;

import com.Encommerce.logica.DetalleOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
@Service
public class DetalleServiceImpl implements IDetalleOrdenService {
    
    @Autowired
    private IDetalleOrdenService IDetalleOrdenService;
    
    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return IDetalleOrdenService.save(detalleOrden);
    }
    
}
