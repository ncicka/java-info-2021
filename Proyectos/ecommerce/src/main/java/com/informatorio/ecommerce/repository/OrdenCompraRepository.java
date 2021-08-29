package com.informatorio.ecommerce.repository;

import java.util.List;

import com.informatorio.ecommerce.domain.OrdenCompra;
import com.informatorio.ecommerce.domain.Usuario;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {

    List<OrdenCompra> findByOrderByIdDesc(Pageable sortedByIdDes);

    List<OrdenCompra> findByUsuario(Usuario usuario);

}
