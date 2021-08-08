package com.informatorio.ecommerce.dto;

public class OperacionCarrito {

    private Integer cantidad;

    private Long productoId;


    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getProductoId() {
        return this.productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    
}
