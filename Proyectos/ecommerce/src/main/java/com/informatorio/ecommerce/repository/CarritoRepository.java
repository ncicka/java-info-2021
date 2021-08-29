package com.informatorio.ecommerce.repository;

import java.util.List;

import com.informatorio.ecommerce.domain.Carrito;
import com.informatorio.ecommerce.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, Long>{

    List<Carrito> findByUsuario(Usuario usuario);

    List<Carrito> findByUsuarioAndEstadoAbierto(Usuario usuario, Boolean estadoAbierto);
    
}
