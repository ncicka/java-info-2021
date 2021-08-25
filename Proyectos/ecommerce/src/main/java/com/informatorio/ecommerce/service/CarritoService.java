package com.informatorio.ecommerce.service;

import com.informatorio.ecommerce.domain.ItemCarrito;
import com.informatorio.ecommerce.repository.CarritoRepository;
import com.informatorio.ecommerce.repository.ItemCarritoRepository;
import com.informatorio.ecommerce.utils.MyEntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ItemCarritoRepository itemCarritoRepository;

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
}
