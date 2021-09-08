package com.informatorio.infocommerce.service;

import java.util.List;
import java.util.Optional;

import com.informatorio.infocommerce.domain.Estado;
import com.informatorio.infocommerce.domain.ItemCarrito;
import com.informatorio.infocommerce.domain.ItemOrdenCompra;
import com.informatorio.infocommerce.domain.OrdenCompra;
import com.informatorio.infocommerce.domain.Usuario;
import com.informatorio.infocommerce.dto.OperacionOrdenCompra;
import com.informatorio.infocommerce.repository.OrdenCompraRepository;
import com.informatorio.infocommerce.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public OrdenCompra crearOrdenCompra 
        (Long usuarioId, OperacionOrdenCompra oOrdenCpra){
        //Cuando se crea la orden de compra siempre en estado confirmada
        Usuario usuarioEncontrado = usuarioRepository.getById(usuarioId);
        OrdenCompra nuevaOrdenCpra = new OrdenCompra();
        nuevaOrdenCpra.setEstado(Estado.CONFIRMADO);
        nuevaOrdenCpra.setCarritoId(oOrdenCpra.getCarritoId());
        nuevaOrdenCpra.setEstado(oOrdenCpra.getEstado());
        nuevaOrdenCpra.setTipo(oOrdenCpra.getTipo());
        nuevaOrdenCpra.setNumero(this.ultimaOrdenCompra()+1);
        nuevaOrdenCpra.setUsuario(usuarioEncontrado);
        return nuevaOrdenCpra;
    }

    public ItemOrdenCompra convertirItem(ItemCarrito itemCarrito){
            ItemOrdenCompra itemOrdenCompra = new ItemOrdenCompra();
            itemOrdenCompra.setCantidad(itemCarrito.getCantidad());
            itemOrdenCompra.setProducto(itemCarrito.getProducto());
            itemOrdenCompra.setPrecioUnitario(itemCarrito.getProducto().getPrecioUnitario());
        return itemOrdenCompra;
    }
    
    public Long ultimaOrdenCompra(){
        Pageable sortedByIdDes = PageRequest.of(0,1);
        List<OrdenCompra> ultimaOrden = ordenCompraRepository.findByOrderByIdDesc(sortedByIdDes);
        Long id = ultimaOrden.isEmpty()?0L:Long.valueOf(ultimaOrden.get(0).getNumero());
        return id;
    }

    public OrdenCompra grabarOrdenCompra(OrdenCompra orden){
        return ordenCompraRepository.save(orden);
    }

    public List<OrdenCompra> VerOrdenesCompra(Long usuarioId){
        Usuario usuarioEncontrado = usuarioRepository.findById(usuarioId).get();
        return ordenCompraRepository.findByUsuario(usuarioEncontrado);
    }

    public Optional<OrdenCompra> VerOrdenCompraId(Long id){
        return ordenCompraRepository.findById(id);
    }
    
    public OrdenCompra cerrarOrdenCompra(Long ordenId){
        OrdenCompra ordenEncontrada = ordenCompraRepository.getById(ordenId);
        ordenEncontrada.setEstado(Estado.CANCELADO);
        return ordenEncontrada;
    }
}
