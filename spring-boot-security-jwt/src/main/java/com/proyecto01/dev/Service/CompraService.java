package com.proyecto01.dev.Service;

import com.proyecto01.dev.infrastracture.ProductoRepository;
import com.proyecto01.dev.domain.Compra;
import com.proyecto01.dev.domain.Producto;
import com.proyecto01.dev.infrastracture.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class CompraService {

    @Autowired
    public CompraRepository compraRepository;
    @Autowired
    public ProductoRepository productoRepository;

    public List<Compra> getAllCompra() { return compraRepository.findAll(); }

    public Compra saveCompra(Compra compra){ return compraRepository.save(compra); }

    public Optional<Compra> updateCompra(Long id, Compra compra){
        Optional<Compra> optionalCompra = compraRepository.findById(id);
        if(optionalCompra.isPresent()){
            Compra eixstingCompra = optionalCompra.get();
            eixstingCompra.setFecha_compra(compra.getFecha_compra());
            eixstingCompra.setMetodo_de_pago(compra.getMetodo_de_pago());
            eixstingCompra.setMonto_Total(compra.getMonto_Total());

            compraRepository.save(eixstingCompra);
        }
        return optionalCompra;
    }

    public Optional<Compra> patchCompra(Long id,Compra compra) {
        Optional<Compra> optionalCompra = compraRepository.findById(id);
        if (optionalCompra.isPresent()) {
            Compra existingCompra = optionalCompra.get();
            if (compra.getFecha_compra() != null) {
                existingCompra.setFecha_compra(compra.getFecha_compra());
            }
            if (compra.getMetodo_de_pago() != null) {
                existingCompra.setMetodo_de_pago(compra.getMetodo_de_pago());
            }
            if (compra.getMonto_Total() != null) {
                existingCompra.setMonto_Total(compra.getMonto_Total());
            }

            compraRepository.save(existingCompra);
        }
        return optionalCompra;
    }

    public Optional<Compra> deleteCompra(Long id) {
        Optional<Compra> optionalCompra = compraRepository.findById(id);
        if (optionalCompra.isPresent()) {
            Compra existingCompra = optionalCompra.get();
            compraRepository.delete(existingCompra);
        }
        return optionalCompra;
    }

    public Optional<Compra> getCompra(Long id) {
        return compraRepository.findById(id);
    }

    public void Compra_Producto(Long idCompra, Long idProducto) {
        Compra compra = compraRepository.findById(idCompra)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la compra con ID: " + idCompra));

        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el producto con ID: " + idProducto));

        if (compra != null && producto != null) {
            if (compra.getProducto() == null) {
                if (producto.getStock() > 0) {
                    compra.setProducto(producto);

                    producto.setStock(producto.getStock() - 1);
                    if (producto.getStock() == 0) {
                        producto.setEstado(false);
                    }

                    productoRepository.save(producto);
                    compraRepository.save(compra);
                } else {
                    throw new IllegalArgumentException("No hay suficiente stock disponible para este producto.");
                }
            } else {
                throw new IllegalArgumentException("La compra ya tiene asignado un producto.");
            }
        }
    }



}