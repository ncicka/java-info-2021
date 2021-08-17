package com.informatorio.ecommerce.controller;

import javax.validation.Valid;

import com.informatorio.ecommerce.domain.Producto;
import com.informatorio.ecommerce.repository.ProductoRepository;

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
    private ProductoRepository productoRepository;
 
    @GetMapping
    public ResponseEntity<?> getProducto(@RequestParam(name="id",required=false) Long id,
        @RequestParam(name="descripcio_com", required= false) String comienza,
        @RequestParam(name="categoria",required = false) String categoria){
        if(id != null){
            return new ResponseEntity<>(productoRepository.findById(id).get(),HttpStatus.OK);
        }
        if(comienza != null){
            return new ResponseEntity<>(productoRepository.findByDescripcionStartingWith(comienza),HttpStatus.OK);
        }
        if(categoria != null){
            return new ResponseEntity<>(productoRepository.findByCategoria(categoria),HttpStatus.OK);
        }
    return new ResponseEntity<>(productoRepository.findAll(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> crearProducto(@Valid @RequestBody Producto producto){
        return new ResponseEntity<>(productoRepository.save(producto),HttpStatus.CREATED);
    }
    
    @PostMapping(value="/{id}")
    public ResponseEntity<?> modificarProducto(@PathVariable("id") Long id,
                                             @Valid @RequestBody Producto producto){
        Producto productoEncontrado = productoRepository.findById(id).get();
        productoEncontrado.setNombre(producto.getNombre());
        productoEncontrado.setDescripcion(producto.getDescripcion());
        productoEncontrado.setCategoria(producto.getCategoria());
        productoEncontrado.setPrecioUnitario(producto.getPrecioUnitario());
        productoEncontrado.setCodigoInventario(producto.getCodigoInventario());
        return new ResponseEntity<>(productoRepository.save(productoEncontrado),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/{id}")
    public void borrarProducto(@PathVariable("id") Long id){
        productoRepository.deleteById(id);
    }

}

