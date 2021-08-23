package com.informatorio.ecommerce.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.informatorio.ecommerce.domain.Producto;
import com.informatorio.ecommerce.repository.ProductoRepository;
import com.informatorio.ecommerce.utils.MyEntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto getProductoId(Long id){
        Producto producto = new Producto();
        try{
            producto = productoRepository.findById(id).get();
        } catch(Exception e){
            throw new MyEntityNotFoundException("No se encuentra el producto: "+id );
        }
        return producto;
    }

    public List<Producto> getProductoComienzaCon(String buscar){
        List<Producto> productos = productoRepository.findByDescripcionStartingWith(buscar);
        if (productos.isEmpty()){
            throw new EntityNotFoundException("No hay resultados a mostrar");
        }
        return productos;
    }

    public List<Producto> getProductoIgualCategoria(String buscar){
        List<Producto> productos = productoRepository.findByCategoria(buscar);
        if (productos.isEmpty()){
            throw new EntityNotFoundException("No hay resultados a mostrar");
        }
        return productos;
    }

    public List<Producto> listarTodos (){
        List<Producto> productos = productoRepository.findAll();
        if (productos.isEmpty()){
            throw new EntityNotFoundException("No hay resultados a mostrar");
        }
        return productos;
    }

    public void BorrarProductoId(Long id){
        try{
            productoRepository.deleteById(id);
        } catch(Exception e){
            throw new MyEntityNotFoundException("No se encuentra el producto: "+id );
        }
    }

    public Producto modificarProductoId(Long id, Producto producto){
        Producto productoEncontrado = this.getProductoId(id);
        productoEncontrado.setNombre(producto.getNombre());
        productoEncontrado.setDescripcion(producto.getDescripcion());
        productoEncontrado.setCategoria(producto.getCategoria());
        productoEncontrado.setPrecioUnitario(producto.getPrecioUnitario());
        productoEncontrado.setCodigoInventario(producto.getCodigoInventario());
        return productoEncontrado;
    }

    public Producto grabarProducto(Producto producto){
        return productoRepository.save(producto);
    }
}
