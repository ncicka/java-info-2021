package com.informatorio.infocommerce.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    private String contenido="";

    @Positive
    private BigDecimal precioUnitario;

    private Boolean publicado = true;

    public Producto() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public BigDecimal getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Boolean isPublicado() {
        return this.publicado;
    }

    public Boolean getPublicado() {
        return this.publicado;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", contenido='" + getContenido() + "'" +
            ", precioUnitario='" + getPrecioUnitario() + "'" +
            ", publicado='" + isPublicado() + "'" +
            "}";
    }

}
