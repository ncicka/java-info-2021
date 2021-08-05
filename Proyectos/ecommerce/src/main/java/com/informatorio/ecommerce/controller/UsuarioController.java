package com.informatorio.ecommerce.controller;

import java.util.List;

import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value="/usuario")
    public List<Usuario> getUsuario(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @GetMapping(value="/usuario/{id}")
    public Usuario getUsuarioId(@PathVariable("id") Long id){
        return usuarioRepository.findById(id).get();
    }
 
    @PutMapping(value="/receta")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    
    @PutMapping(value="/usuario/{id}")
    public Usuario modificarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        Usuario usuarioEncontrado = usuarioRepository.findById(id).get();
        usuarioEncontrado.setApellido(usuario.getApellido());
        usuarioEncontrado.setNombre(usuario.getNombre());
        usuarioEncontrado.setDireccion(usuario.getDireccion());
        return usuarioRepository.save(usuarioEncontrado);
    }

    @DeleteMapping(value="usuario/{id}")
    public void borrarUsuario(@PathVariable("id") Long id){
        usuarioRepository.deleteById(id);;
    }
}
