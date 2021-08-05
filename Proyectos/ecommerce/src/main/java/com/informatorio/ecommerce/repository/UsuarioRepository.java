package com.informatorio.ecommerce.repository;

import java.util.List;

import com.informatorio.ecommerce.domain.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
    List<Usuario> findAll();
}
