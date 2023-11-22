package com.proyecto01.dev.controllers;

import com.proyecto01.dev.Service.SnackService;
import com.proyecto01.dev.domain.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/snack")
public class SnackController {

    @Autowired
    private SnackService snackService;

    @GetMapping
    public ResponseEntity<List<Snack>> AllSnack(){
        List<Snack> cafe = snackService.getAllSnack();
        return new ResponseEntity<>(cafe,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> PostSnack(@RequestBody Snack snack){
        snackService.saveSnack(snack);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSnack(@PathVariable Long id, @RequestBody Snack snack){
        Optional<Snack> updatedSnack = snackService.updateSnack(id,snack);
        return updatedSnack.isPresent() ? ResponseEntity.status(200).body("Updated") :
                ResponseEntity.status(404).body("Not Found");

    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchSnack(@PathVariable Long id, @RequestBody Snack snack){
        Optional<Snack> patchSnack = snackService.patchSnack(id,snack);
        return patchSnack.isPresent() ? ResponseEntity.status(200).body("Updated partially") :
                ResponseEntity.status(404).body("Not Found");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSnack(@PathVariable Long id) {
        Optional<Snack> deletedSnack = snackService.deleteSnack(id);
        return deletedSnack.isPresent() ? ResponseEntity.status(200).body("Deleted") : ResponseEntity.status(404).body("Not Found");
    }
}
