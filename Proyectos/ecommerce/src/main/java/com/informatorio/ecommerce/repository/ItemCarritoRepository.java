package com.informatorio.ecommerce.repository;

import com.informatorio.ecommerce.domain.ItemCarrito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long>{

    
}
