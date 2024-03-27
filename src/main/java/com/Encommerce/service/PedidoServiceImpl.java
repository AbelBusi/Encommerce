package com.Encommerce.service;

import com.Encommerce.logica.Pedido;
import com.Encommerce.repository.IPedidoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoRepository iPedidoRepository;

    @Override
    public Pedido save(Pedido pedido) {
        return iPedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> findAll() {

        return iPedidoRepository.findAll();

    }

    //Metodo para generar codigo de pedido, de manera automatica
    public String generarNumeroPedido() {

        int numero = 0;

        String numeroConcatenado = "";

        List<Pedido> pedidos = findAll();

        List<Integer> numeros = new ArrayList<Integer>();

        pedidos.stream().forEach(p -> numeros.add(Integer.parseInt(p.getNumeroPedido())));

        //Validacion
        if (pedidos.isEmpty()) {

            numero = 1;

        } else {

            numero = numeros.stream().max(Integer::compare).get();
            numero++;

        }

        //Se introduce el formato 000000000
        if (numero < 10) {

            numeroConcatenado = "000000000" + String.valueOf(numero);

        } else if (numero < 100) {

            numeroConcatenado = "00000000" + String.valueOf(numero);

        } else if (numero < 1000) {

            numeroConcatenado = "0000000" + String.valueOf(numero);

        } else if (numero < 10000) {

            numeroConcatenado = "000000" + String.valueOf(numero);

        }

        return numeroConcatenado;

    }

}
