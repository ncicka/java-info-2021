package com.informatorio.infocommerce.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No hay nada")
public class MyEntityNotFoundException extends RuntimeException {

    public MyEntityNotFoundException(String mensaje){
        super(mensaje);
    }
}

