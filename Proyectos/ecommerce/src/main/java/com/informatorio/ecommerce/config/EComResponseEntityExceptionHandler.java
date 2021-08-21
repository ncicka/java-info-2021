package com.informatorio.ecommerce.config;

import com.informatorio.ecommerce.dto.ApiError;
import com.informatorio.ecommerce.utils.MyEntityNotFoundException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EComResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
                MethodArgumentNotValidException ex, 
                HttpHeaders headers, HttpStatus status, WebRequest request){
        ApiError error = new ApiError();
        error.setStatus(status);
        error.setMensaje(ex.getMessage());
        error.setCantidadErrores(ex.getErrorCount());
        error.setDebugMensaje(ex.getLocalizedMessage());
        error.setDebugMensaje(ex.fillInStackTrace().toString());
        return new ResponseEntity<Object>(error, HttpStatus.I_AM_A_TEAPOT);
    }

    @Override
    public ResponseEntity<Object> handleTypeMismatch(
        TypeMismatchException ex, 
        HttpHeaders headers, 
        HttpStatus status, 
        WebRequest request){
            ApiError error = new ApiError();
            error.setStatus(status);
            error.setMensaje(ex.getMessage());
            error.setCantidadErrores(error.getCantidadErrores()+1);
            error.setDebugMensaje(ex.getLocalizedMessage());
            error.setDebugMensaje(ex.fillInStackTrace().toString());
            return new ResponseEntity<Object>(error, HttpStatus.CONFLICT);          
        }
    
    private ResponseEntity<Object> buildResponseEntity(ApiError apiError){
        return new ResponseEntity<Object>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(MyEntityNotFoundException.class)
    protected ResponseEntity<Object> handleMyEntityNotFound(
        MyEntityNotFoundException ex){
            ApiError apiError = new ApiError();
            apiError.setStatus(HttpStatus.NOT_FOUND);
            apiError.setMensaje(ex.getMessage());
            apiError.setCantidadErrores(apiError.getCantidadErrores()+1);
            apiError.setDebugMensaje(ex.fillInStackTrace().toString());
            return buildResponseEntity(apiError);
    }

    @ExceptionHandler(javax.persistence.EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
        javax.persistence.EntityNotFoundException ex) {
            ApiError apiError = new ApiError();
            apiError.setStatus(HttpStatus.NOT_FOUND);
            apiError.setMensaje(ex.getMessage());
            apiError.setCantidadErrores(apiError.getCantidadErrores()+1);
            apiError.setDebugMensaje(ex.fillInStackTrace().toString());
            return buildResponseEntity(apiError);
    }
}
