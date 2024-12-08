package com.example.appdevassignment.service;

import com.example.appdevassignment.dtos.PetRequestDTO;
import com.example.appdevassignment.entities.Household;
import com.example.appdevassignment.dtos.PetDTO;
import com.example.appdevassignment.entities.Pet;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.appdevassignment.repository.HouseholdRepository;
import com.example.appdevassignment.repository.PetRepository;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final HouseholdRepository householdRepository;

    @Override
    @Transactional
    public Pet createPet(PetRequestDTO dto) {
        Household household = householdRepository.findById(dto.householdEircode())
                .orElseThrow(() -> new EntityNotFoundException("Household not found"));
        Pet pet = new Pet();
        pet.setName(dto.name());
        pet.setBreed(dto.breed());
        pet.setType(dto.type());
        pet.setAge(dto.age());
        pet.setHousehold(household);
        validatePet(pet);
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found"));
    }

    @Override
    public void delete(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Pet updateName(Long id, String newName) {
        Pet pet = findById(id);
        pet.setName(newName);
        return petRepository.save(pet);
    }

    @Override
    public void deleteByName(String name) {
        petRepository.deletePetsByNameIgnoreCase(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetDTO> getAllPetsAsDTO() {
        return petRepository.findAll().stream()
                .map(pet -> new PetDTO(pet.getName(), pet.getBreed()))
                .collect(Collectors.toList());
    }

    private void validatePet(Pet pet) {
        if (pet.getAge() < 0) {
            throw new IllegalArgumentException("Pet age cannot be negative");
        }
    }
}