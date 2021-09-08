package com.informatorio.infocommerce.repository;

import java.util.List;

import com.informatorio.infocommerce.domain.Carrito;
import com.informatorio.infocommerce.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    
    List<Carrito> findByUsuario(Usuario usuario);

    List<Carrito> findByUsuarioAndEstadoAbierto(Usuario usuario, Boolean estadoAbierto);
    
}
