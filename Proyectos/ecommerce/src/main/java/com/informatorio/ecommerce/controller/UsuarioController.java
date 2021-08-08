package com.informatorio.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.repository.UsuarioRepository;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getUsuario(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @GetMapping(value="/{id}")
    public Usuario getUsuarioId(@PathVariable("id") Long id){
        return usuarioRepository.findById(id).get();
    }
 
    @PutMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioRepository.save(usuario),HttpStatus.CREATED);
    }
    
    @PostMapping(value="/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario){
        Usuario usuarioEncontrado = usuarioRepository.findById(id).get();
        usuarioEncontrado.setApellido(usuario.getApellido());
        usuarioEncontrado.setNombre(usuario.getNombre());
        usuarioEncontrado.setDireccion(usuario.getDireccion());
        usuarioEncontrado.setEmail(usuario.getEmail());
        return new ResponseEntity<>(usuarioRepository.save(usuarioEncontrado),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/{id}")
    public void borrarUsuario(@PathVariable("id") Long id){
        usuarioRepository.deleteById(id);;
    }
}
