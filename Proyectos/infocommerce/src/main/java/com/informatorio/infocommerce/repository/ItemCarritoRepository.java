package com.informatorio.infocommerce.repository;

import java.util.List;

import com.informatorio.infocommerce.domain.ItemCarrito;
import com.informatorio.infocommerce.domain.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long> {

    //List<ItemCarrito> findByProductoId(Long productoId);

    List<ItemCarrito> findDistinctByProducto(Producto producto);
    
}
