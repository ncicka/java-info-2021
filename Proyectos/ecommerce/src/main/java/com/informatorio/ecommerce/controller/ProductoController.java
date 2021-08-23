package com.informatorio.ecommerce.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import com.informatorio.ecommerce.domain.Producto;
import com.informatorio.ecommerce.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController{

    @Autowired 
    private ProductoService productoService;
 
    //para probar validacion de id que no existe
    @GetMapping(value="/prueba")
    public ResponseEntity<?> getProductoprueba
        (@RequestParam(name="id") Long id)
        throws EntityNotFoundException {
        return new ResponseEntity<>(productoService.getProductoId(id),HttpStatus.OK);   
    }
     
    @GetMapping
    public ResponseEntity<?> getProducto(@RequestParam(name="id",required=false) Long id,
        @RequestParam(name="descripcio_com", required= false) String comienza,
        @RequestParam(name="categoria",required = false) String categoria){
        if(id != null){
            return new ResponseEntity<>(productoService.getProductoId(id),HttpStatus.OK);
        } 
        if(comienza != null){
            return new ResponseEntity<>(productoService.getProductoComienzaCon(comienza),HttpStatus.OK);
        }
        if(categoria != null){
            return new ResponseEntity<>(productoService.getProductoIgualCategoria(categoria),HttpStatus.OK);
        }
    return new ResponseEntity<>(productoService.listarTodos(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> crearProducto(@Valid @RequestBody Producto producto){
        return new ResponseEntity<>(productoService.grabarProducto(producto),HttpStatus.CREATED);
    }
    
    @PostMapping(value="/{id}")
    public ResponseEntity<?> modificarProducto(@PathVariable("id") Long id,
                                             @Valid @RequestBody Producto producto){
        Producto productoModificado = productoService.modificarProductoId(id, producto);
        return new ResponseEntity<>(productoService.grabarProducto(productoModificado),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/{id}")
    public void borrarProducto(@PathVariable("id") Long id){
        productoService.BorrarProductoId(id);
    }

}

