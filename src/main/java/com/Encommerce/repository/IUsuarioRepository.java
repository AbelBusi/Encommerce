package com.Encommerce.repository;

import com.Encommerce.logica.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar
 */

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
}
