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
public class Producto {

    private int idProducto;

    private String nombreProducto;
    private String descripcionProducto;
    private String imagenProducto;
    private Double precioProducto;
    private int cantidadProducto;

}
