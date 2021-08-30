package com.informatorio.infocommerce.repository;

import java.util.List;

import com.informatorio.infocommerce.domain.Producto;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto,Long>{

    List<Producto> findByNombreContains(String nombre);

    List<Producto> findByPublicado(Boolean publicado);
    
}
