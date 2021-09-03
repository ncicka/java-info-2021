package com.informatorio.infocommerce.repository;

import java.util.List;
import java.util.Optional;

import com.informatorio.infocommerce.domain.OrdenCompra;
import com.informatorio.infocommerce.domain.Usuario;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {

    List<OrdenCompra> findByOrderByIdDesc(Pageable sortedByIdDes);

    List<OrdenCompra> findByUsuario(Usuario usuario);

    Optional<OrdenCompra> findById(Long id);

}