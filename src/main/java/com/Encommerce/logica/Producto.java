package com.Encommerce.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import lombok.ToString;

/**
 *
 * @author cesar
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    private String nombreProducto;
    private String descripcionProducto;
    private String imagenProducto;
    private Double precioProducto;
    private int cantidadProducto;
    
    @ManyToOne
    private Usuario usuario;
    

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombreProducto=" + 
                nombreProducto + ", descripcionProducto=" + descripcionProducto 
                + ", imagenProducto=" + imagenProducto + ", precioProducto=" 
                + precioProducto + ", cantidadProducto=" + cantidadProducto + '}';
    }
    
}
