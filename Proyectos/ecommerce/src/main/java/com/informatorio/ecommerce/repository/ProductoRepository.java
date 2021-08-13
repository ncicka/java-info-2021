package com.informatorio.ecommerce.repository;

import java.util.List;

import com.informatorio.ecommerce.domain.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

    List<Producto> findAll();

    List<Producto> findByDescripcionStartingWith(String descripcion);
}
