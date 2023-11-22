package com.proyecto01.dev.Service;

import com.proyecto01.dev.domain.Cliente;
import com.proyecto01.dev.infrastracture.ClienteRepository;
import com.proyecto01.dev.domain.Compra;
import com.proyecto01.dev.infrastracture.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CompraRepository compraRepository;

    public List<Cliente> getAllClient() { return clienteRepository.findAll(); }

    public Cliente saveCliente(Cliente cliente){ return clienteRepository.save(cliente); }

    public Optional<Cliente> updateCliente(Long id, Cliente cliente){
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if(optionalCliente.isPresent()){
            Cliente existingCliente = optionalCliente.get();
            existingCliente.setUserName(cliente.getUserName());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setContrasena(cliente.getContrasena());
            existingCliente.setCantidad_compras(cliente.getCantidad_compras());
            existingCliente.setDireccion(cliente.getDireccion());
            existingCliente.setCompras(cliente.getCompras());

            clienteRepository.save(existingCliente);
        }
        return optionalCliente;
    }

    public Optional<Cliente> patchCliente(Long id,Cliente cliente) {
        Optional<Cliente> OptionalCliente = clienteRepository.findById(id);
        if (OptionalCliente.isPresent()) {
            Cliente existingCliente = OptionalCliente.get();
            if (cliente.getUserName() != null) {
                existingCliente.setUserName(cliente.getUserName());
            }
            if (cliente.getEmail() != null) {
                existingCliente.setEmail(cliente.getEmail());
            }
            if (cliente.getContrasena() != null) {
                existingCliente.setContrasena(cliente.getContrasena());
            }
            if (cliente.getCantidad_compras() != null) {
                existingCliente.setCantidad_compras(cliente.getCantidad_compras());
            }
            if (cliente.getDireccion() != null) {
                existingCliente.setDireccion(cliente.getDireccion());
            }
            if (cliente.getCompras() != null){
                existingCliente.setCompras(cliente.getCompras());
            }

            clienteRepository.save(existingCliente);
        }
        return OptionalCliente;
    }

    public Optional<Cliente> deleteCliente(Long id) {
        Optional<Cliente> optionalSong = clienteRepository.findById(id);
        if (optionalSong.isPresent()) {
            Cliente existingSong = optionalSong.get();
            clienteRepository.delete(existingSong);
        }
        return optionalSong;
    }
    public void AgregarCompra(Long id, Long id2){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        Compra compra = compraRepository.findById(id2).orElse(null);

        if (cliente != null && compra != null) {
            if (!cliente.getCompras().contains(compra)) {
                cliente.getCompras().add(compra);
                clienteRepository.save(cliente);
            }
        }
    }

}