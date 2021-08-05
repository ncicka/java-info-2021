package com.informatorio.ecommerce.config;

import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ecommerRunner implements CommandLineRunner{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        // Agregar usuarios
        /*
        Usuario usuario = new Usuario();
        usuario.setApellido("Lopez");
        usuario.setDireccion("Belgrano 245");
        usuario.setNombre("Eduardo");

        usuarioRepository.save(usuario);
        */
    }
    
}
