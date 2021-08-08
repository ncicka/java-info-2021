package com.informatorio.ecommerce.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController{

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getProducto(){
        List<Producto> productos = productoRepository.findAll();
        return productos;
    }

    @GetMapping(value="/{id}")
    public Producto getProductoId(@PathVariable("id") Long id){
        return productoRepository.findById(id).get();
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

