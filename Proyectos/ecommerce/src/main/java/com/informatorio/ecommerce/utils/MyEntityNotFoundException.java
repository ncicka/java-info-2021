package com.informatorio.ecommerce.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Cuando se lanza una excepcion anotada y no se maneja en otro lugar
//esta anotacion hace que se devuelva HTTP correcto y no el 500(por defecto)
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No hay nada")
public class MyEntityNotFoundException extends RuntimeException{

    public MyEntityNotFoundException(String mensaje){
        super(mensaje);
    }
    
}
