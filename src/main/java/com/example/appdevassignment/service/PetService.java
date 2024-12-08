package com.example.appdevassignment.service;
import com.example.appdevassignment.dtos.PetDTO;
import com.example.appdevassignment.dtos.PetRequestDTO;
import com.example.appdevassignment.entities.Pet;

import java.util.List;


public interface PetService {
    Pet createPet(PetRequestDTO petDTO);
    List<PetDTO> getAllPetsAsDTO();
    List<Pet> findAll();
    Pet findById(Long id);
    void delete(Long id);
    Pet updateName(Long id, String newName);
    void deleteByName(String name);


}