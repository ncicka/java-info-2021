package com.informatorio.infocommerce.repository;

import com.informatorio.infocommerce.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
