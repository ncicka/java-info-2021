package com.informatorio.ecommerce.domain;

import java.time.LocalDate;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Boolean estadoAbierto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(mappedBy= "carrito", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Carrito> carrito = new ArrayList<>();
    
    @CreationTimestamp
    private LocalDate fechaAlta;

    @UpdateTimestamp
    private LocalDate fechaUltimaModif;

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

    public LocalDate getFechaAlta() {
        return this.fechaAlta;
    }

    public LocalDate getFechaUltimaModif() {
        return this.fechaUltimaModif;
    }


}
