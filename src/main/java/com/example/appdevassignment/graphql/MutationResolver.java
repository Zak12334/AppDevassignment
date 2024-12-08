package com.example.appdevassignment.graphql;

import com.example.appdevassignment.entities.Household;
import com.example.appdevassignment.entities.Pet;
import com.example.appdevassignment.repository.HouseholdRepository;
import com.example.appdevassignment.repository.PetRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {
    private final HouseholdRepository householdRepository;
    private final PetRepository petRepository;

    public MutationResolver(HouseholdRepository householdRepository, PetRepository petRepository) {
        this.householdRepository = householdRepository;
        this.petRepository = petRepository;
    }

   /* @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public Household createHousehold(@Argument String eircode,
                                     @Argument int numberOfOccupants,
                                     @Argument int maximumOccupants,
                                     @Argument boolean ownerOccupied) {
        Household household = new Household();
        household.setEircode(eircode);
        household.setNumberOfOccupants(numberOfOccupants);
        household.setMaximumOccupants(maximumOccupants);
        household.setOwnerOccupied(ownerOccupied);
        return householdRepository.save(household);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public Pet createPet(@Argument String name,
                         @Argument String breed,
                         @Argument String type,
                         @Argument int age,
                         @Argument String householdEircode) {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setBreed(breed);
        pet.setType(type);
        pet.setAge(age);
        pet.setHousehold(householdRepository.findById(householdEircode)
                .orElseThrow(() -> new RuntimeException("Household not found")));
        return petRepository.save(pet);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public boolean deleteHousehold(@Argument String eircode) {
        try {
            householdRepository.deleteById(eircode);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public boolean deletePet(@Argument Long id) {
        try {
            petRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }*/
   // }
}