package com.informatorio.ecommerce.repository;

import com.informatorio.ecommerce.domain.ItemOrdenCompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrdenCompraRepository extends JpaRepository<ItemOrdenCompra, Long>{
    
}
