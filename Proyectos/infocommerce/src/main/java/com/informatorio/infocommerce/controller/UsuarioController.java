package com.informatorio.infocommerce.controller;

import com.informatorio.infocommerce.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
 
    //Consulta por parametro
    @GetMapping
    public ResponseEntity<?> getUsuarioById(@RequestParam(name="id",required=false) Long id){
        if (id != null){
            return new ResponseEntity<>(usuarioService.getUsuarioId(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(usuarioService.listarTodos(), HttpStatus.OK);
    }
}
