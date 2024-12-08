package com.example.appdevassignment.graphql;

import com.example.appdevassignment.entities.Household;
import com.example.appdevassignment.entities.Pet;
import com.example.appdevassignment.repository.HouseholdRepository;
import com.example.appdevassignment.repository.PetRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;


@Controller
public class HouseholdResolver {
    private final HouseholdRepository householdRepository;
    private final PetRepository petRepository;

    public HouseholdResolver(HouseholdRepository householdRepository, PetRepository petRepository) {
        this.householdRepository = householdRepository;
        this.petRepository = petRepository;
    }

    @QueryMapping
    public Iterable<Household> households() {
        return householdRepository.findAll();
    }

    @QueryMapping
    public Household household(@Argument String eircode) {
        return householdRepository.findById(eircode).orElse(null);
    }

    @SchemaMapping(typeName = "Pet")
    public String householdEircode(Pet pet) {
        return pet.getHousehold().getEircode();
    }
}
