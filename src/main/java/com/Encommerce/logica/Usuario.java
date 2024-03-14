package com.Encommerce.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
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
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String nombreUsuario;
    private String nickUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private String direccionUsuario;
    private String telefonoUsuario;
    private String tipoUsuario;
    
    public Usuario(int idUsuario,String nombreUsuario,String nickUsuario, String emailUsuario
            ,String passwordUsuario,String direccionUsuario, String telefonoUsuario,String tipoUsuario){
    
        this.idUsuario=idUsuario;
        this.nombreUsuario=nombreUsuario;
        this.nickUsuario=nickUsuario;
        this.emailUsuario=emailUsuario;
        this.passwordUsuario=passwordUsuario;
        this.direccionUsuario=direccionUsuario;
        this.telefonoUsuario=telefonoUsuario;
        this.tipoUsuario=tipoUsuario;
    }

    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;
    
    @OneToMany (mappedBy = "usuario")
    private List<Pedido> pedidos;

}
