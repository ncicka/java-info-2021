package com.informatorio.ecommerce.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.informatorio.ecommerce.domain.Estado;
import com.informatorio.ecommerce.domain.Tipo;

public class OperacionOrdenCompra {
    
    private Long carritoId;
    
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.CONFIRMADO;

    public OperacionOrdenCompra() {
    }

    public Long getCarritoId() {
        return this.carritoId;
    }

    public void setCarritoId(Long carritoId) {
        this.carritoId = carritoId;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
