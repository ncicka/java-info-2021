package com.informatorio.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import com.informatorio.ecommerce.domain.Carrito;
import com.informatorio.ecommerce.domain.ItemCarrito;
import com.informatorio.ecommerce.domain.Producto;
import com.informatorio.ecommerce.dto.OperacionCarrito;
import com.informatorio.ecommerce.repository.CarritoRepository;
import com.informatorio.ecommerce.repository.ProductoRepository;
import com.informatorio.ecommerce.service.CarritoService;
import com.informatorio.ecommerce.repository.ItemCarritoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarritoController {
    
    private CarritoRepository carritoRepository;
    private ProductoRepository productoRepository;
    private ItemCarritoRepository itemCarritoRepository;
    private CarritoService carritoService;

    public CarritoController(CarritoRepository carritoRepository,
                        ProductoRepository productoRepository,
                        ItemCarritoRepository itemCarritoRepository,
                        CarritoService carritoService) {
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
        this.itemCarritoRepository = itemCarritoRepository;
        this.carritoService = carritoService;
    }

    @GetMapping(value="/usuario/{id}/carrito")
    public ResponseEntity<?> getCarrito(@PathVariable("id") Long id){
        List<Carrito> carritos = carritoService.VerCarritoActivo(id);
        return new ResponseEntity<>(carritos, HttpStatus.OK);
    }

    @PutMapping(value="/usuario/{id}/carrito")
    public ResponseEntity<?> crearCarrito(@PathVariable("id") Long id,
                                        @Valid @RequestBody Carrito carrito){
        carrito = carritoService.CrearCarrito(id, carrito);
        return new ResponseEntity<>(carritoRepository.save(carrito),HttpStatus.CREATED);
        }    
    
    @PostMapping(value="/carrito/{carritoId}")
    public ResponseEntity<?> modificarCarrito(@PathVariable("carritoId") Long carritoId,
                                            @Valid @RequestBody Carrito carrito){
            Carrito carritoEncontrado = carritoRepository.getById(carritoId);
            carritoEncontrado.setEstadoAbierto(carrito.getEstadoAbierto());
            return new ResponseEntity<>(carritoRepository.save(carritoEncontrado),HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping(value="/carrito/{carritoId}")
    public void borrarCarrito(@PathVariable("carritoId") Long carritoId){
        carritoService.BorrarCarritoId(carritoId);
    }  
    
    //Items de carrito
    @PutMapping(value="/carrito/{carritoId}")
    public ResponseEntity<?> agregarItemACarrito(@PathVariable("carritoId") Long carritoId,
                                            @Valid @RequestBody OperacionCarrito ocarrito){
        Carrito carrito = carritoRepository.getById(carritoId);
        Producto producto = productoRepository.getById(ocarrito.getProductoId());
        ItemCarrito nuevoItem = new ItemCarrito();
        nuevoItem.setCarrito(carrito);
        nuevoItem.setProducto(producto);
        nuevoItem.setCantidad(ocarrito.getCantidad());
        carrito.agregarItem(nuevoItem);
        return new ResponseEntity<>(carritoRepository.save(carrito), HttpStatus.ACCEPTED);
        }

        @PostMapping(value="/carrito/item/{itemId}")
        public ResponseEntity<?> modificarCantidadItemDeCarrito(@PathVariable("itemId") Long itemId,
                                                @Valid @RequestBody OperacionCarrito operacion){
            ItemCarrito modificadoItem = carritoService.ModificarCantidadItemCarrito(itemId, operacion.getCantidad());
            return new ResponseEntity<>(itemCarritoRepository.save(modificadoItem), HttpStatus.ACCEPTED);
            }
    
    @DeleteMapping(value="/carrito/{carritoId}/item/{itemId}")
        public void borrarItemDeCarrito(@PathVariable("carritoId") Long carritoId,
                                   @PathVariable("itemId") Long itemId){
            Carrito carritoEncontrado = carritoRepository.getById(carritoId);
            ItemCarrito itemEncontrado = itemCarritoRepository.getById(itemId);
            carritoEncontrado.removerItem(itemEncontrado);
            carritoRepository.save(carritoEncontrado);
        }
}
