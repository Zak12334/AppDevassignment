package com.example.appdevassignment.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record HouseholdRequestDTO(
        @NotBlank(message = "Eircode is required")
        String eircode,

        @Min(value = 1, message = "Must have at least one occupant")
        int numberOfOccupants,

        @Min(value = 1, message = "Maximum occupants must be at least 1")
        int maximumOccupants,

        boolean ownerOccupied
) {}