package com.informatorio.ecommerce.repository;

import com.informatorio.ecommerce.domain.ItemCarrito;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long>{
    
}
