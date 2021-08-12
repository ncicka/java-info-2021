package com.informatorio.ecommerce.domain;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Carrito extends FechaCreacionModif{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Boolean estadoAbierto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(mappedBy= "carrito", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<ItemCarrito> items = new ArrayList<>();
    
    public Carrito() {
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
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

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void agregarItem(ItemCarrito item){
        items.add(item);
        item.setCarrito(this); 
    }

    public void removerItem(ItemCarrito item){
        items.remove(item);
        item.setCarrito(null);   
    }

    public List<ItemCarrito> getItems() {
        return this.items;
    }

}
