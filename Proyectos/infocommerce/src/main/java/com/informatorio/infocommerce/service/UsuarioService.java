package com.informatorio.infocommerce.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.informatorio.infocommerce.domain.Usuario;
import com.informatorio.infocommerce.repository.UsuarioRepository;
import com.informatorio.infocommerce.utils.MyEntityNotFoundException;

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
            throw new MyEntityNotFoundException("No se encnuentra el suario: "+id);
        }
        return usuario;
    }

    public List<Usuario> ListarPorCiudad(String ciudad){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            usuarios = usuarioRepository.findByciudadContains(ciudad);
        }catch(Exception e){
            throw new MyEntityNotFoundException("No hay datos a mostrar para "+ciudad);
        }
        return usuarios;
    }

    public List<Usuario> ListarPorFechaCreacion(LocalDate fechaCreacion){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            usuarios = usuarioRepository.findByfechaAltaAfter(fechaCreacion);
        }catch(Exception e){
            throw new MyEntityNotFoundException("No hay datos a mostrar anterior a "+fechaCreacion);
        }
        
        return usuarios;
    }
    public List<Usuario> listarTodos (){
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()){
            throw new EntityNotFoundException("No hay resultados a mostrar");
        }
        return usuarios;
    }
    
    public Usuario grabarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario modificarUsuarioId(Long id, Usuario usuario){
        Usuario usuarioEncontrado = this.getUsuarioId(id);
        System.out.println("PASA POR AQUI");
        if (usuario.getApellido()!=null){
            usuarioEncontrado.setApellido(usuario.getApellido());
        }
        if (usuario.getNombre()!=null){
            usuarioEncontrado.setNombre(usuario.getNombre());
        }
        if (usuario.getCiudad()!=null){
            usuarioEncontrado.setCiudad(usuario.getCiudad());
        }
        if (usuario.getEmail()!=null){
            usuarioEncontrado.setEmail(usuario.getEmail());
        }
        if (usuario.getProvincia()!=null){
            usuarioEncontrado.setProvincia(usuario.getProvincia());
        }
        if (usuario.getPais()!=null){
            usuarioEncontrado.setPais(usuario.getPais());
        }
        return usuarioEncontrado;
    }
    public void BorrarUsuarioId(Long id){
        try{
            usuarioRepository.deleteById(id);
        } catch(Exception e){
            throw new MyEntityNotFoundException("No se encuentra el usuario: "+id );
        }
    }
}
