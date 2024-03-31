package com.Encommerce.repository;

import com.Encommerce.logica.Pedido;
import com.Encommerce.logica.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar
 */
@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer>{
    
    List<Pedido> findByUsuario(Usuario usuario);
    
}
