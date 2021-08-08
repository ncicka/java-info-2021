package com.informatorio.ecommerce.repository;

import java.util.List;

import com.informatorio.ecommerce.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    List<Usuario> findAll();
}
