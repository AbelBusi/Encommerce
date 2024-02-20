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
public class Usuario {

    private int idUsuario;

    private String nombreUsuario;
    private String nickUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private String direccionUsuario;
    private String telefonoUsuario;
    private String tipoUsuario;
    

}
