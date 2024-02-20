package com.Encommerce.logica;

import java.util.Date;
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
public class Pedido {

    private int idPedido;

    private String numeroPedido;
    private Date fechaCreacionPedido;
    private Date fechaEntregaPedido;

}
