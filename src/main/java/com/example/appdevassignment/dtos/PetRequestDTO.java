package com.example.appdevassignment.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PetRequestDTO(
        @NotBlank(message = "Pet name is required")
        String name,

        @NotBlank(message = "Breed is required")
        String breed,

        @NotBlank(message = "Type is required")
        String type,

        @Min(value = 0, message = "Age cannot be negative")
        int age,

        @NotBlank(message = "Household eircode is required")
        String householdEircode
) {}