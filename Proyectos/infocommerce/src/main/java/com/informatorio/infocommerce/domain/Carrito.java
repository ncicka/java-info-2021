package com.informatorio.infocommerce.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean estadoAbierto;

    private String generadoPor;

    @Transient
    private BigDecimal total;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(mappedBy= "carrito", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<ItemCarrito> items = new ArrayList<>();

    public Carrito() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isEstadoAbierto() {
        return this.estadoAbierto;
    }

    public Boolean getEstadoAbierto() {
        return this.estadoAbierto;
    }

    public void setEstadoAbierto(Boolean estadoAbierto) {
        this.estadoAbierto = estadoAbierto;
    }

    public String getGeneradoPor() {
        return this.generadoPor;
    }

    public void setGeneradoPor(String generadoPor) {
        this.generadoPor = generadoPor;
    }

    public BigDecimal getTotal() {
        this.total = new BigDecimal(0);
        for (ItemCarrito itemCarrito : items) {
            this.total = this.total.add(itemCarrito.getTotalLinea());    
        }
        return this.total;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemCarrito> getItems() {
        return this.items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }

    public void agregarItem(ItemCarrito item){
        items.add(item);
        item.setCarrito(this); 
    }

    public void removerItem(ItemCarrito item){
        items.remove(item);
        item.setCarrito(null);   
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", estadoAbierto='" + isEstadoAbierto() + "'" +
            ", generadoPor='" + getGeneradoPor() + "'" +
            ", total='" + getTotal() + "'" +
            ", usuario='" + getUsuario() + "'" +
            "}";
    }

}
