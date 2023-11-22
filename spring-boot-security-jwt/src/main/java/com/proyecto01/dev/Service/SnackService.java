package com.proyecto01.dev.Service;

import com.proyecto01.dev.infrastracture.SnackRepository;
import com.proyecto01.dev.domain.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnackService {

    @Autowired
    private SnackRepository snackRepository;

    public List<Snack> getAllSnack() { return snackRepository.findAll(); }

    public Snack saveSnack(Snack snack){ return snackRepository.save(snack); }

    public Optional<Snack> updateSnack(Long id, Snack snack){
        Optional<Snack> optionalSnack = snackRepository.findById(id);
        if(optionalSnack.isPresent()){
            Snack existingSnack = optionalSnack.get();
            existingSnack.setNombre(snack.getNombre());
            existingSnack.setEstado(snack.getEstado());
            existingSnack.setImg(snack.getImg());
            existingSnack.setPrecio(snack.getPrecio());
            existingSnack.setStock(snack.getStock());
            existingSnack.setFabricante(snack.getFabricante());
            existingSnack.setCategoria(snack.getCategoria());



            snackRepository.save(existingSnack);
        }
        return optionalSnack;
    }

    public Optional<Snack> patchSnack(Long id,Snack snack) {
        Optional<Snack> OptionalSnack = snackRepository.findById(id);
        if (OptionalSnack.isPresent()) {
            Snack existingSnack = OptionalSnack.get();
            if (snack.getNombre() != null) {
                existingSnack.setNombre(snack.getNombre());
            }
            if (snack.getEstado() != null) {
                existingSnack.setEstado(snack.getEstado());
            }
            if (snack.getImg() != null) {
                existingSnack.setImg(snack.getImg());
            }
            if (snack.getPrecio() != null) {
                existingSnack.setPrecio(snack.getPrecio());
            }
            if (snack.getStock() != null) {
                existingSnack.setStock(snack.getStock());
            }
            if (snack.getFabricante() != null){
                existingSnack.setFabricante(snack.getFabricante());
            }
            if(snack.getCategoria() != null){
                existingSnack.setCategoria(snack.getCategoria());
            }

            snackRepository.save(existingSnack);
        }
        return OptionalSnack;
    }

    public Optional<Snack> deleteSnack(Long id) {
        Optional<Snack> optionalSnack = snackRepository.findById(id);
        if (optionalSnack.isPresent()) {
            Snack existingSnack = optionalSnack.get();
            snackRepository.delete(existingSnack);
        }

        return optionalSnack;
    }
}
