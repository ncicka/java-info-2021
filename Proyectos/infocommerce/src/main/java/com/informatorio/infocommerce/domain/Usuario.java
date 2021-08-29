package com.informatorio.infocommerce.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.informatorio.infocommerce.utils.ValidationHelper;

@Entity
public class Usuario extends FechaCreaMod{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Debe ingresar el nombre")
    private String nombre;

    @NotBlank(message="Debe ingresar el apellido")
    private String apellido;
    
    @Column(unique = true)
    @Email(regexp = ValidationHelper.EMAIL_REGEX)
    private String email;

    @JsonIgnore
    @Min(8)
    @Pattern(regexp = ValidationHelper.PASS_REGEX, 
    message = "Letras y números, una Mayúscula, un caracter especial, largo mínimo 8")
    private String password;

    @NotBlank(message="Debe ingresar la ciudad")
    private String cuidad;

    @NotBlank(message="Debe ingresar la provincia")
    private String provincia;

    @NotBlank(message="Debe ingresar el pais")
    private String pais;

   // @OneToMany(mappedBy= "usuario", cascade = CascadeType.ALL, orphanRemoval = true )
   // private List<Carrito> carritos = new ArrayList<>();

    public Usuario() {
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

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCuidad() {
        return this.cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", cuidad='" + getCuidad() + "'" +
            ", provincia='" + getProvincia() + "'" +
            ", pais='" + getPais() + "'" +
            "}";
    }

}
