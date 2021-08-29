package com.informatorio.ecommerce.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemOrdenCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Positive
    private BigDecimal precioUnitario;

    @Positive
    private Integer cantidad;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private OrdenCompra ordencompra;

    public ItemOrdenCompra() {
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public BigDecimal getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public OrdenCompra getOrdencompra() {
        return this.ordencompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra){
        this.ordencompra = ordenCompra;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
 
}
