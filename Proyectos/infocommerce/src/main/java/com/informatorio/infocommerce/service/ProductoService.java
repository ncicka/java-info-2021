package com.informatorio.infocommerce.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.informatorio.infocommerce.domain.Producto;
import com.informatorio.infocommerce.repository.ProductoRepository;
import com.informatorio.infocommerce.utils.MyEntityNotFoundException;

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

    public List<Producto> getProductoContenga(String buscar){
        List<Producto> productos = productoRepository.findByNombreContains(buscar);
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
    public List<Producto> getProductoPublicado(Boolean buscar){
        List<Producto> productos = productoRepository.findByPublicado(buscar);
        if (productos.isEmpty()){
            throw new EntityNotFoundException("No hay resultados a mostrar");
        }
        return productos;
    }
    
    public Producto grabarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto modificarProductoId(Long id, Producto producto){
        Producto productoEncontrado = this.getProductoId(id);

        if(producto.getNombre()!=null){
            productoEncontrado.setNombre(producto.getNombre());
        }
        if(producto.getDescripcion()!=null){
            productoEncontrado.setDescripcion(producto.getDescripcion());
        }
        if(producto.getPrecioUnitario()!=null){
            productoEncontrado.setPrecioUnitario(producto.getPrecioUnitario());
        }
        if(producto.getPublicado()!=null){
            productoEncontrado.setPublicado(producto.getPublicado());
        }
        //contenido no es null
        if(producto.getContenido()!=null && !producto.getContenido().isEmpty()){
            productoEncontrado.setContenido(producto.getContenido());
        }
        return productoEncontrado;
    }

    public void BorrarProductoId(Long id){
        try{
            productoRepository.deleteById(id);
        } catch(Exception e){
            throw new MyEntityNotFoundException("No se encuentra el producto: "+id );
        }
    }
}
