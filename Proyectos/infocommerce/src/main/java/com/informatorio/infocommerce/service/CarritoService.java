package com.informatorio.infocommerce.service;

import java.util.List;

import com.informatorio.infocommerce.domain.Carrito;
import com.informatorio.infocommerce.domain.Usuario;
import com.informatorio.infocommerce.repository.CarritoRepository;
import com.informatorio.infocommerce.repository.UsuarioRepository;
import com.informatorio.infocommerce.utils.MyEntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {
    
    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Carrito getCarritoId(Long id){
        Carrito carrito = new Carrito();
        try{
            carrito = carritoRepository.findById(id).get();
        } catch(Exception e){
            throw new MyEntityNotFoundException("No se encuentra el carrito: "+id );
        }
        return carrito;
    }

    public Carrito CrearCarrito(Long id, Carrito carrito){
        Usuario usuario = usuarioRepository.getById(id);
        if (!this.TieneCarritoActivo(id)){
            carrito.setUsuario(usuario);
            carrito.setEstadoAbierto(true);
            carrito.setGeneradoPor(carrito.getGeneradoPor());
        } else{
            throw new MyEntityNotFoundException("Ya tiene un carrito abierto ");
        }      
        return carrito;
    }

    public Boolean TieneCarritoActivo(Long usuarioId){
        Usuario usuario = usuarioRepository.getById(usuarioId);
        System.out.println("pasa por aqui");
        List<Carrito> tieneCarrito = carritoRepository.findByUsuarioAndEstadoAbierto(
            usuario, true);
        System.out.println(tieneCarrito);
        return !tieneCarrito.isEmpty();
    }

    public Carrito grabarCarrito(Carrito carrito){
        return carritoRepository.save(carrito);
    }
    public void BorrarCarritoId(Long id){
        try{
            carritoRepository.deleteById(id);
        } catch(Exception e){
            throw new MyEntityNotFoundException("No se encuentra el carrito: "+id );
        }
    }
    
    public List<Carrito> VerCarritoActivo(Long usuarioId){
        Usuario usuario = usuarioRepository.getById(usuarioId);
        List<Carrito> tieneCarrito = carritoRepository.findByUsuarioAndEstadoAbierto(
            usuario, true);
        return tieneCarrito;
    }
}
