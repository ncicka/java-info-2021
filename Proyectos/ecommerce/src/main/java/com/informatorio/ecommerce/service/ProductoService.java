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
            //throw new EntityNotFoundException("No se encuentra el producto: "+id );
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

    public void BorrarProductoId(Long id){
        try{
            productoRepository.deleteById(id);
        } catch(Exception e){
            throw new MyEntityNotFoundException("No se encuentra el producto: "+id );
            //throw new EntityNotFoundException("No se encuentra el producto: "+id );
        }
    }
}
