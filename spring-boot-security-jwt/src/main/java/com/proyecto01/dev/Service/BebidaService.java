package com.proyecto01.dev.Service;

import com.proyecto01.dev.domain.Bebida;
import com.proyecto01.dev.infrastracture.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    public List<Bebida> getAllBebida() { return bebidaRepository.findAll(); }

    public Bebida saveBebida(Bebida bebida){ return bebidaRepository.save(bebida); }

    public Optional<Bebida> updateBebida(Long id, Bebida bebida){
        Optional<Bebida> optionalBebida = bebidaRepository.findById(id);
        if(optionalBebida.isPresent()){
            Bebida existingBebida = optionalBebida.get();
            existingBebida.setNombre(bebida.getNombre());
            existingBebida.setEstado(bebida.getEstado());
            existingBebida.setImg(bebida.getImg());
            existingBebida.setPrecio(bebida.getPrecio());
            existingBebida.setStock(bebida.getStock());
            existingBebida.setFabricante(bebida.getFabricante());
            existingBebida.setTipo_bebida(bebida.getTipo_bebida());
            existingBebida.setTamano(bebida.getTamano());



            bebidaRepository.save(existingBebida);
        }
        return optionalBebida;
    }

    public Optional<Bebida> patchBebida(Long id,Bebida bebida) {
        Optional<Bebida> OptionalBebida = bebidaRepository.findById(id);
        if (OptionalBebida.isPresent()) {
            Bebida existingBebida = OptionalBebida.get();
            if (bebida.getNombre() != null) {
                existingBebida.setNombre(bebida.getNombre());
            }
            if (bebida.getEstado() != null) { //maybe falla
                existingBebida.setEstado(bebida.getEstado());
            }
            if (bebida.getImg() != null) {
                existingBebida.setImg(bebida.getImg());
            }
            if (bebida.getPrecio() != null) {
                existingBebida.setPrecio(bebida.getPrecio());
            }
            if (bebida.getStock() != null) {
                existingBebida.setStock(bebida.getStock());
            }
            if (bebida.getFabricante() != null){
                existingBebida.setFabricante(bebida.getFabricante());
            }
            if(bebida.getTipo_bebida() != null){
                existingBebida.setTipo_bebida(bebida.getTipo_bebida());
            }
            if(bebida.getTamano() != null){
                existingBebida.setTamano(bebida.getTamano());
            }

            bebidaRepository.save(existingBebida);
        }
        return OptionalBebida;
    }

    public Optional<Bebida> deleteBebida(Long id) {
        Optional<Bebida> optionalBebida = bebidaRepository.findById(id);
        if (optionalBebida.isPresent()) {
            Bebida existingBebida = optionalBebida.get();
            bebidaRepository.delete(existingBebida);
        }
        return optionalBebida;
    }

}
