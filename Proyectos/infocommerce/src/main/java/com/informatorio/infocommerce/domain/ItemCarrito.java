package com.informatorio.infocommerce.domain;

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
public class ItemCarrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private Integer cantidad;

    
    @ManyToOne(fetch = FetchType.LAZY)
    private Carrito carrito;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    public ItemCarrito() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @JsonIgnore
    public Carrito getCarrito() {
        return this.carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    //para devolver el id de producto en Json Postman
    public Long getProductoId(){
        return producto.getId();
    }

    //para devolver el precio unitario del producto en Json Postman
    public BigDecimal getPrecioUnitario(){
        return producto.getPrecioUnitario();
    }

    public BigDecimal getTotalLinea(){
        return this.producto.getPrecioUnitario().multiply(new BigDecimal(this.cantidad));
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            ", carrito='" + getCarrito().getId() + "'" +
            ", producto='" + getProducto().getNombre() + "'" +
            ", total='" + getTotalLinea() + "'" +
            "}";
    }

}
