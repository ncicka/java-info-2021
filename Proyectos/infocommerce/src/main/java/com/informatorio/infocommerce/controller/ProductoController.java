package com.informatorio.infocommerce.controller;

import javax.validation.Valid;

import com.informatorio.infocommerce.domain.Producto;
import com.informatorio.infocommerce.service.ProductoService;

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
@RequestMapping("producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<?> getProducto(@RequestParam(name="quecontenga", required= false) String quecontenga,
        @RequestParam(name="publicado",required = false) Boolean publicado,
        @RequestParam(name="id", required = false) Long id){
        if(quecontenga != null){
            return new ResponseEntity<>(productoService.getProductoContenga(quecontenga),HttpStatus.OK);
        }
        if(publicado != null){
            return new ResponseEntity<>(productoService.getProductoPublicado(publicado),HttpStatus.OK);
        }
        if(id != null){
            return new ResponseEntity<>(productoService.getProductoId(id),HttpStatus.OK);
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

    // El Delete segun convencion tiene que devolver NOT_CONTENT
    @DeleteMapping(value="/{id}")
    public void borrarProducto(@PathVariable("id") Long id){
        productoService.BorrarProductoId(id);
    }
}
