package com.informatorio.ecommerce.domain;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class FechaCreacionModif {
    
    @CreationTimestamp
    private LocalDate fechaAlta;

    @UpdateTimestamp
    private LocalDate fechaUltimaModif;

    public LocalDate getFechaAlta() {
        return this.fechaAlta;
    }

    public LocalDate getFechaUltimaModif() {
        return this.fechaUltimaModif;
    }

}
