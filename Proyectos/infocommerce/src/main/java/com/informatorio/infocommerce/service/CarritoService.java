package com.informatorio.infocommerce.service;

import java.math.BigDecimal;
import java.util.List;

import com.informatorio.infocommerce.domain.Carrito;
import com.informatorio.infocommerce.domain.ItemCarrito;
import com.informatorio.infocommerce.domain.Producto;
import com.informatorio.infocommerce.domain.Usuario;
import com.informatorio.infocommerce.dto.OperacionCarrito;
import com.informatorio.infocommerce.repository.CarritoRepository;
import com.informatorio.infocommerce.repository.ItemCarritoRepository;
import com.informatorio.infocommerce.repository.ProductoRepository;
import com.informatorio.infocommerce.repository.UsuarioRepository;
import com.informatorio.infocommerce.utils.MyEntityNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class CarritoService {
    
    private CarritoRepository carritoRepository;
    private UsuarioRepository usuarioRepository;
    private ProductoRepository productoRepository;
    private ItemCarritoRepository itemCarritoRepository;

    public CarritoService(CarritoRepository carritoRespository,
                    UsuarioRepository usuarioRepository,
                    ProductoRepository productoRepository,
                    ItemCarritoRepository itemCarritoRepository){
        this.carritoRepository = carritoRespository;
        this.usuarioRepository = usuarioRepository;
        this.productoRepository = productoRepository;
        this.itemCarritoRepository = itemCarritoRepository;
                    }

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
        if (!this.TieneCarritoActivo(id) ){
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
        //System.out.println("pasa por aqui");
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

    public Carrito CrearItemCarrito(Long carritoId, OperacionCarrito oCarrito){
        Carrito carrito = carritoRepository.getById(carritoId);
        Producto producto = productoRepository.getById(oCarrito.getProductoId());
        ItemCarrito nuevoItem = new ItemCarrito();
        List<ItemCarrito> itemEncontrado =itemCarritoRepository.findDistinctByProductoAndCarrito(producto, carrito);
        if(itemEncontrado.isEmpty()){
            nuevoItem.setCarrito(carrito);
            nuevoItem.setProducto(producto);
            nuevoItem.setCantidad(oCarrito.getCantidad());
            carrito.agregarItem(nuevoItem);
        } else{
            throw new MyEntityNotFoundException("Ya existe el producto en el carrito no se agrega "
                    +carrito.getId());
        }  
        return carrito;
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

    public ItemCarrito grabarItemCarrito(ItemCarrito itemCarrito){
        return itemCarritoRepository.save(itemCarrito);
    }

    public ItemCarrito encontrarItemCarrito(Long itemId){
        ItemCarrito itemEncontrado = itemCarritoRepository.getById(itemId);
        return itemEncontrado;
    }

    public List<ItemCarrito> ListarItemCarrito(Long carritoId){
        Carrito carritoEncontrado = carritoRepository.getById(carritoId);
        List<ItemCarrito> itemsCarrito = carritoEncontrado.getItems();
        return itemsCarrito;
    }

    public Boolean carritoVacio(Long carritoId){
        Carrito carritoEncontrado = carritoRepository.getById(carritoId);
        return carritoEncontrado.getTotal().equals(new BigDecimal(0));
    }

    public void CerrarCarrito(Long carritoId){
        Carrito carritoEncontrado = carritoRepository.getById(carritoId);
        carritoEncontrado.setEstadoAbierto(false);
        carritoRepository.save(carritoEncontrado);
    }

}
