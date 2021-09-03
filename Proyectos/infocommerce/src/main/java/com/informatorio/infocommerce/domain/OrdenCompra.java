package com.informatorio.infocommerce.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrdenCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    private Long carritoId;

    @Column(unique=true)
    private Long numero;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @OneToMany(mappedBy= "ordencompra", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<ItemOrdenCompra> items = new ArrayList<>();


    public OrdenCompra() {
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getCarritoId() {
        return this.carritoId;
    }

    public void setCarritoId(Long carritoId) {
        this.carritoId = carritoId;
    }

    public Long getNumero() {
        return this.numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<ItemOrdenCompra> getItems() {
        return this.items;
    }

    public void setItems(List<ItemOrdenCompra> items) {
        this.items = items;
    }

    public void agregarItem(ItemOrdenCompra item){
        items.add(item);
        item.setOrdencompra(this); 
    }

    public void removerItem(ItemOrdenCompra item){
        items.remove(item);
        item.setOrdencompra(null);
    }
    
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", usuario='" + getUsuario() + "'" +
            ", carritoId='" + getCarritoId() + "'" +
            ", numero='" + getNumero() + "'" +
            ", estado='" + getEstado() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }

}
