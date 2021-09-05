package com.informatorio.ecommerce.service;

import java.util.List;

import com.informatorio.ecommerce.domain.Carrito;
import com.informatorio.ecommerce.domain.ItemCarrito;
import com.informatorio.ecommerce.domain.Usuario;
import com.informatorio.ecommerce.repository.CarritoRepository;
import com.informatorio.ecommerce.repository.ItemCarritoRepository;
import com.informatorio.ecommerce.repository.UsuarioRepository;
import com.informatorio.ecommerce.utils.MyEntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ItemCarritoRepository itemCarritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Carrito CrearCarrito(Long id, Carrito carrito){
        Usuario usuario = usuarioRepository.getById(id);
        if (!this.TieneCarritoActivo(id)){
            carrito.setUsuario(usuario);
            carrito.setEstadoAbierto(true);
        } else{
            throw new MyEntityNotFoundException("Ya tiene un carrito abierto ");
        }      
        return carrito;
    }

    public Boolean TieneCarritoActivo(Long usuarioId){
        Usuario usuario = usuarioRepository.getById(usuarioId);
        List<Carrito> tieneCarrito = carritoRepository.findByUsuarioAndEstadoAbierto(
            usuario, true);
        return !tieneCarrito.isEmpty();
    }

    public List<Carrito> VerCarritoActivo(Long usuarioId){
        Usuario usuario = usuarioRepository.getById(usuarioId);
        List<Carrito> tieneCarrito = carritoRepository.findByUsuarioAndEstadoAbierto(
            usuario, true);
        return tieneCarrito;
    }

    public void BorrarCarritoId(Long id){
        try{
            carritoRepository.deleteById(id);
        } catch(Exception e){
            throw new MyEntityNotFoundException("No se encuentra el carrito: "+id );
        }
    }    
    
    public ItemCarrito ModificarCantidadItemCarrito(Long itemId, Integer cantidad){
        ItemCarrito modificarItem = new ItemCarrito();
        try{
            modificarItem = itemCarritoRepository.findById(itemId).get();
            modificarItem.setCantidad(cantidad);
        } catch (Exception e) {
            throw new MyEntityNotFoundException("No se encuentra el item de carrito: "+itemId);
        }
        return modificarItem;
    }

    public List<ItemCarrito> ListarItemCarrito(Long carritoId){
        Carrito carritoEncontrado = carritoRepository.getById(carritoId);
        List<ItemCarrito> itemsCarrito = carritoEncontrado.getItems();
        return itemsCarrito;
    }

    public void CerrarCarrito(Long carritoId){
        Carrito carritoEncontrado = carritoRepository.getById(carritoId);
        carritoEncontrado.setEstadoAbierto(false);
        carritoRepository.save(carritoEncontrado);
    }

}
