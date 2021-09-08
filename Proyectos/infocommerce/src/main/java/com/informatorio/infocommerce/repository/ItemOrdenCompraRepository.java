package com.informatorio.infocommerce.repository;

import com.informatorio.infocommerce.domain.ItemOrdenCompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrdenCompraRepository extends JpaRepository<ItemOrdenCompra, Long>{
    
}
