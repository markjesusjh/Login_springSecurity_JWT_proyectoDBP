package com.proyecto01.dev.Service;

import com.proyecto01.dev.domain.Producto;
import com.proyecto01.dev.infrastracture.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    public ProductoRepository productoRepository;

    public List<Producto> getAllProducto() { return productoRepository.findAll(); }

    public Producto saveProducto(Producto producto){ return productoRepository.save(producto); }

    public Optional<Producto> updateProducto(Long id, Producto producto){
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if(optionalProducto.isPresent()){
            Producto eixstingProducto = optionalProducto.get();
            eixstingProducto.setNombre(producto.getNombre());
            eixstingProducto.setEstado(producto.getEstado());
            eixstingProducto.setImg(producto.getImg());
            eixstingProducto.setPrecio(producto.getPrecio());
            eixstingProducto.setStock(producto.getStock());
            eixstingProducto.setFabricante(producto.getFabricante());

            productoRepository.save(eixstingProducto);
        }
        return optionalProducto;
    }

    public Optional<Producto> patchProducto(Long id,Producto producto) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto existingProducto = optionalProducto.get();
            if (producto.getNombre() != null) {
                existingProducto.setNombre(producto.getNombre());
            }
            if (producto.getEstado() != null) { //maybe falla
                existingProducto.setEstado(producto.getEstado());
            }
            if (producto.getImg() != null) {
                existingProducto.setImg(producto.getImg());
            }
            if (producto.getPrecio() != null) {
                existingProducto.setPrecio(producto.getPrecio());
            }
            if (producto.getStock() != null) {
                existingProducto.setStock(producto.getStock());
            }
            if (producto.getFabricante() != null){
                existingProducto.setFabricante(producto.getFabricante());
            }

            productoRepository.save(existingProducto);
        }
        return optionalProducto;
    }

    public Optional<Producto> deleteProducto(Long id) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto existingProducto = optionalProducto.get();
            productoRepository.delete(existingProducto);
        }
        return optionalProducto;
    }

    public Optional<Producto> getProducto(Long id) {
        return productoRepository.findById(id);
    }


}
