package com.informatorio.infocommerce.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import com.informatorio.infocommerce.domain.Usuario;
import com.informatorio.infocommerce.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<?> getUsuarioById(@RequestParam(name="id",required=false) Long id,
        @RequestParam(name="ciudad", required=false) String ciudad,
        @RequestParam(name="fechaCreacion",required=false) 
        @DateTimeFormat(iso=ISO.DATE) LocalDate fechaCreacion){
        
        if (id != null){
            return new ResponseEntity<>(usuarioService.getUsuarioId(id),HttpStatus.OK);
        }
        if (ciudad !=null){
            return new ResponseEntity<>(usuarioService.ListarPorCiudad(ciudad),HttpStatus.OK);
        }
        if (fechaCreacion != null){
            return new ResponseEntity<>(usuarioService.ListarPorFechaCreacion(fechaCreacion),HttpStatus.OK);
        }
        return new ResponseEntity<>(usuarioService.listarTodos(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.grabarUsuario(usuario),HttpStatus.CREATED);
    }

    @PostMapping(value="/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable("id") Long id,
        @RequestBody Usuario usuario){
        Usuario usuarioModificado = usuarioService.modificarUsuarioId(id, usuario);
        return new ResponseEntity<>(usuarioService.grabarUsuario(usuarioModificado),HttpStatus.ACCEPTED);
    }

    // El Delete segun convencion tiene que devolver NOT_CONTENT
    @DeleteMapping(value="/{id}")
    public void borrarUsuario(@PathVariable("id") Long id){
        usuarioService.BorrarUsuarioId(id);
    }

}
