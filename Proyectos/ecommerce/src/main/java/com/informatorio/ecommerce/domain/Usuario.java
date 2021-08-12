package com.informatorio.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.informatorio.ecommerce.utils.ValidationHelper;

@Entity
public class Usuario extends FechaCreacionModif{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    //@NotEmpty(message="Debe ingresar el nombre")
    // NotEmpty deja pasar espacios en blanco
    @NotBlank(message="Debe ingresar el nombre")
    private String nombre;

    @NotBlank(message="Debe ingresar el apellido")
    private String apellido;

    @NotBlank(message="Debe ingresar la dirección")
    private String direccion;
    
    @Column(unique = true)
    @Email(regexp = ValidationHelper.EMAIL_REGEX)
    private String email;

    @OneToMany(mappedBy= "usuario", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Carrito> carritos = new ArrayList<>();

    public Usuario() {
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

     public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Carrito> getCarritos() {
        return this.carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }
 
    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
 
 
}
