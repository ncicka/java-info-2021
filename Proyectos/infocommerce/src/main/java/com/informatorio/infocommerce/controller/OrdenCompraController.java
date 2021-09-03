package com.informatorio.infocommerce.controller;

import java.util.List;

import com.informatorio.infocommerce.domain.ItemCarrito;
import com.informatorio.infocommerce.domain.OrdenCompra;
import com.informatorio.infocommerce.dto.OperacionOrdenCompra;
import com.informatorio.infocommerce.service.CarritoService;
import com.informatorio.infocommerce.service.OrdenCompraService;
import com.informatorio.infocommerce.utils.MyEntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdenCompraController {
    
    private OrdenCompraService ordenCompraService;
    private CarritoService carritoService;

    public OrdenCompraController(OrdenCompraService ordenCompraService,
            CarritoService carritoService){
        this.ordenCompraService = ordenCompraService;
        this.carritoService = carritoService;
    }

    @PutMapping(value="usuario/{id}/orden")
    public ResponseEntity<?> crearOrdenCompra(@PathVariable("id") Long id,
                                        @RequestBody OperacionOrdenCompra oOrdenCpra){
        OrdenCompra ordenCompra = new OrdenCompra();
        //Verificar que Exista un carrito abierto y
        //que coincida con el de la oOrdenCpra
        if (carritoService.TieneCarritoActivo(id) && 
            carritoService.VerCarritoActivo(id).get(0).getId() == oOrdenCpra.getCarritoId()&&
            !carritoService.carritoVacio(oOrdenCpra.getCarritoId())){
            
            //Armar la orden de compra con los datos del carrito
            OrdenCompra nuevaOrden = ordenCompraService.crearOrdenCompra(id,oOrdenCpra);

            //Guardar la orden de compra
            ordenCompra = ordenCompraService.grabarOrdenCompra(nuevaOrden);

            //Guardar los items de carrito
            List<ItemCarrito> itemsCarrito = carritoService.ListarItemCarrito(oOrdenCpra.getCarritoId());
            
            for (ItemCarrito item : itemsCarrito) {
                ordenCompra.agregarItem(ordenCompraService.convertirItem(item));
            }
            //Grabar el detalle de la Orden de Compra
            ordenCompraService.grabarOrdenCompra(ordenCompra);
            //Cerrar el carrito 
            carritoService.CerrarCarrito(oOrdenCpra.getCarritoId());   
        }else{
            throw new MyEntityNotFoundException("No hay carrito activo o no existe o esta vacio" );
        }
        
    return new ResponseEntity<>(ordenCompra,HttpStatus.CREATED);
    }    

    @GetMapping(value="usuario/{id}/orden")
    public ResponseEntity<?> getUsuarioById(@PathVariable(name="id") Long id){

            return new ResponseEntity<>(ordenCompraService.VerOrdenesCompra(id), HttpStatus.OK);
    }

    @PostMapping(value="admin/orden/{ordenid}")
    public ResponseEntity<?> modificarOrdenCompra(@PathVariable(name="ordenid") Long ordenid){
        OrdenCompra modificadaOrden = ordenCompraService.cerrarOrdenCompra(ordenid);
        return new ResponseEntity<>(ordenCompraService.grabarOrdenCompra(modificadaOrden), HttpStatus.OK);
    }

    @GetMapping(value="orden/{id}")
    public ResponseEntity<?> getOrdenById(@PathVariable(name="id") Long id){

            return new ResponseEntity<>(ordenCompraService.VerOrdenCompraId(id), HttpStatus.OK);
    }
}
