package com.informatorio.infocommerce.repository;

import java.util.List;

import com.informatorio.infocommerce.domain.Carrito;
import com.informatorio.infocommerce.domain.ItemCarrito;
import com.informatorio.infocommerce.domain.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long> {

    //List<ItemCarrito> findByProductoId(Long productoId);

    List<ItemCarrito> findDistinctByProductoAndCarrito(Producto producto, Carrito carrito);
    
}
