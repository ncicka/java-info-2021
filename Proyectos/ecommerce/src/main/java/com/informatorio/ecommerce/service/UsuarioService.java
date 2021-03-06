package com.informatorio.ecommerce.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.repository.UsuarioRepository;
import com.informatorio.ecommerce.utils.MyEntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioId(Long id){
        Usuario usuario = new Usuario();
        try{
            usuario = usuarioRepository.findById(id).get();
        } catch(Exception e){
            throw new MyEntityNotFoundException("No se encuentra el usuario: "+id );
        }
        return usuario;
    }
 
    public List<Usuario> listarTodos (){
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()){
            throw new EntityNotFoundException("No hay resultados a mostrar");
        }
        return usuarios;
    }

    public void BorrarUsuarioId(Long id){
        try{
            usuarioRepository.deleteById(id);
        } catch(Exception e){
            throw new MyEntityNotFoundException("No se encuentra el usuario: "+id );
        }
    }
    public Usuario modificarUsuarioId(Long id, Usuario usuario){
        Usuario usuarioEncontrado = this.getUsuarioId(id);
        usuarioEncontrado.setApellido(usuario.getApellido());
        usuarioEncontrado.setNombre(usuario.getNombre());
        usuarioEncontrado.setDireccion(usuario.getDireccion());
        usuarioEncontrado.setEmail(usuario.getEmail());
        return usuarioEncontrado;
    }
    
    public Usuario grabarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

}
