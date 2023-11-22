package com.proyecto01.dev.Service;

import com.proyecto01.dev.domain.Cafe;
import com.proyecto01.dev.infrastracture.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CafeService {

    @Autowired
    private CafeRepository cafeRepository;

    public List<Cafe> getAllCafe() { return cafeRepository.findAll(); }

    public Cafe saveCafe(Cafe cafe){ return cafeRepository.save(cafe); }

    public Optional<Cafe> updateCafe(Long id, Cafe cafe){
        Optional<Cafe> optionalCafe = cafeRepository.findById(id);
        if(optionalCafe.isPresent()){
            Cafe existingCafe = optionalCafe.get();
            existingCafe.setNombre(cafe.getNombre());
            existingCafe.setEstado(cafe.getEstado());
            existingCafe.setImg(cafe.getImg());
            existingCafe.setPrecio(cafe.getPrecio());
            existingCafe.setStock(cafe.getStock());
            existingCafe.setFabricante(cafe.getFabricante());
            existingCafe.setTipo_cafe(cafe.getTipo_cafe());



            cafeRepository.save(existingCafe);
        }
        return optionalCafe;
    }

    public Optional<Cafe> patchCafe(Long id,Cafe cafe) {
        Optional<Cafe> OptionalCafe = cafeRepository.findById(id);
        if (OptionalCafe.isPresent()) {
            Cafe existingCafe = OptionalCafe.get();
            if (cafe.getNombre() != null) {
                existingCafe.setNombre(cafe.getNombre());
            }
            if (cafe.getEstado() != null) { //maybe falla
                existingCafe.setEstado(cafe.getEstado());
            }
            if (cafe.getImg() != null) {
                existingCafe.setImg(cafe.getImg());
            }
            if (cafe.getPrecio() != null) {
                existingCafe.setPrecio(cafe.getPrecio());
            }
            if (cafe.getStock() != null) {
                existingCafe.setStock(cafe.getStock());
            }
            if (cafe.getFabricante() != null){
                existingCafe.setFabricante(cafe.getFabricante());
            }
            if(cafe.getTipo_cafe() != null){
                existingCafe.setTipo_cafe(cafe.getTipo_cafe());
            }

            cafeRepository.save(existingCafe);
        }
        return OptionalCafe;
    }

    public Optional<Cafe> deleteCafe(Long id) {
        Optional<Cafe> optionaCafe = cafeRepository.findById(id);
        if (optionaCafe.isPresent()) {
            Cafe existingCafe = optionaCafe.get();
            cafeRepository.delete(existingCafe);
        }
        return optionaCafe;
    }

}
