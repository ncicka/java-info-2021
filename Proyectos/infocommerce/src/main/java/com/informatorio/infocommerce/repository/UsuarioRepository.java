package com.informatorio.infocommerce.repository;

import java.time.LocalDate;
import java.util.List;

import com.informatorio.infocommerce.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    List<Usuario> findByciudadContains(String ciudad);

    List<Usuario> findByfechaAltaAfter(LocalDate fechaCreacion);
    
}
