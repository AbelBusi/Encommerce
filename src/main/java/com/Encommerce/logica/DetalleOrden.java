package com.Encommerce.logica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author cesar
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleOrden {

    private int idDetalleOrden;

    private String nombreDetalleOrden;
    private double cantidadOrden;
    private double precioOrden;
    private double totalOrden;

}
