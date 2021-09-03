package com.informatorio.infocommerce.controller;

import java.util.List;

import javax.validation.Valid;

import com.informatorio.infocommerce.domain.Carrito;
import com.informatorio.infocommerce.domain.ItemCarrito;
import com.informatorio.infocommerce.dto.OperacionCarrito;
import com.informatorio.infocommerce.service.CarritoService;

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

    private CarritoService carritoService;

    public CarritoController(CarritoService carritoService){
        this.carritoService = carritoService;
    }
    @GetMapping(value="/usuario/{id}/carrito")
    public ResponseEntity<?> getCarrito(@PathVariable("id") Long id){
        List<Carrito> carritos = carritoService.VerCarritoActivo(id);
        return new ResponseEntity<>(carritos, HttpStatus.OK);
    }

    @PutMapping(value="/usuario/{id}/carrito")
    public ResponseEntity<?> crearCarrito(@PathVariable("id") Long id,
                                        @Valid @RequestBody Carrito carritoBody){
        Carrito carrito = carritoService.CrearCarrito(id, carritoBody);
        return new ResponseEntity<>(carritoService.grabarCarrito(carrito),HttpStatus.CREATED);
        }    
    
    @PostMapping(value="/carrito/{carritoId}")
    public ResponseEntity<?> modificarCarrito(@PathVariable("carritoId") Long carritoId,
                                            @Valid @RequestBody Carrito carrito){
            Carrito carritoEncontrado = carritoService.getCarritoId(carritoId);
            carritoEncontrado.setEstadoAbierto(carrito.getEstadoAbierto());
            return new ResponseEntity<>(carritoService.grabarCarrito(carritoEncontrado),HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping(value="/carrito/{carritoId}")
    public void borrarCarrito(@PathVariable("carritoId") Long carritoId){
        carritoService.BorrarCarritoId(carritoId);
    }  

    // Items de carrito
    @PutMapping(value="/carrito/{carritoId}")
    public ResponseEntity<?> agregarItemACarrito(@PathVariable("carritoId") Long carritoId,
                                            @Valid @RequestBody OperacionCarrito ocarrito){

        Carrito carrito = carritoService.CrearItemCarrito(carritoId, ocarrito);
        return new ResponseEntity<>(carritoService.grabarCarrito(carrito), HttpStatus.ACCEPTED);
        }

    @PostMapping(value="/carrito/item/{itemId}")
    public ResponseEntity<?> modificarCantidadItemDeCarrito(@PathVariable("itemId") Long itemId,
                                                @Valid @RequestBody OperacionCarrito operacion){
        ItemCarrito modificadoItem = carritoService.ModificarCantidadItemCarrito(itemId, operacion.getCantidad());
        return new ResponseEntity<>(carritoService.grabarItemCarrito(modificadoItem), HttpStatus.ACCEPTED);
    }

    //Borro el item de carrito y devuelvo el carrito sin el item
    @DeleteMapping(value="/carrito/{carritoId}/item/{itemId}")
        public ResponseEntity<?> borrarItemDeCarrito(@PathVariable("carritoId") Long carritoId,
                                   @PathVariable("itemId") Long itemId){
            Carrito carritoEncontrado = carritoService.getCarritoId(carritoId);
            ItemCarrito itemEncontrado = carritoService.encontrarItemCarrito(itemId);
            carritoEncontrado.removerItem(itemEncontrado);
            return new ResponseEntity<>(carritoService.grabarCarrito(carritoEncontrado), HttpStatus.ACCEPTED);
        }
}
