package com.informatorio.infocommerce.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiError {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String mensaje;
    private int cantidadErrores;
    private String debugMensaje;
    
    public ApiError(){
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status){
        this();
        this.status = status;
    }
    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCantidadErrores() {
        return this.cantidadErrores;
    }

    public void setCantidadErrores(int cantidadErrores) {
        this.cantidadErrores = cantidadErrores;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDebugMensaje() {
        return this.debugMensaje;
    }

    public void setDebugMensaje(String debugMensaje) {
        this.debugMensaje= debugMensaje;
    }
  
}
