package com.informatorio.ecommerce.controller;

import javax.validation.Valid;

import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> getUsuarioById(@RequestParam(name="id",required=false) Long id){
        if (id != null){
            return new ResponseEntity<>(usuarioService.getUsuarioId(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(usuarioService.listarTodos(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.grabarUsuario(usuario),HttpStatus.CREATED);
    }
    
    @PostMapping(value="/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable("id") Long id,
         @Valid @RequestBody Usuario usuario){
        Usuario usuarioModificado = usuarioService.modificarUsuarioId(id, usuario);
        return new ResponseEntity<>(usuarioService.grabarUsuario(usuarioModificado),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/{id}")
    public void borrarUsuario(@PathVariable("id") Long id){
        usuarioService.BorrarUsuarioId(id);
    }
}
