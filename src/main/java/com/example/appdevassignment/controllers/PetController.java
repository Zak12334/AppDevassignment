package com.example.appdevassignment.controllers;
import com.example.appdevassignment.dtos.PetRequestDTO;
import com.example.appdevassignment.entities.Pet;
import com.example.appdevassignment.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@Valid @RequestBody PetRequestDTO petDTO) {
        return ResponseEntity.ok(petService.createPet(petDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.delete(id);
        return ResponseEntity.noContent().build();
    }

@DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deletePetsByName(@PathVariable String name) {
        petService.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
}