package com.Encommerce.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author cesar
 */
@Getter
@Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String nombreProducto;
    private String descripcionProducto;
    private Double precioProducto;
    private int cantidadProducto;
    private String imagenProducto;

    @ManyToOne
    private Usuario usuario;

    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto, String descripcionProducto, Double precioProducto, int cantidadProducto, String imagenProducto, Usuario usuario) {
        super();
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
        this.imagenProducto = imagenProducto;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto
                + ", nombreProducto=" + nombreProducto
                + ", descripcionProducto=" + descripcionProducto
                + ", precioProducto=" + precioProducto
                + ", cantidadProducto=" + cantidadProducto
                + ", imagenProducto=" + imagenProducto + '}';
    }

}
