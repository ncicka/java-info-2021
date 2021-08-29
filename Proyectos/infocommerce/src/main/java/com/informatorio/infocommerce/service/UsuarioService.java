package com.informatorio.infocommerce.service;

import java.util.List;

import com.informatorio.infocommerce.domain.Usuario;
import com.informatorio.infocommerce.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioId(Long id){
        Usuario usuario = new Usuario();
        usuario = usuarioRepository.findById(id).get();
        return usuario;
    }

    public List<Usuario> listarTodos (){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }
}
