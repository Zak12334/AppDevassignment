package com.example.appdevassignment.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Household {
    @Id
    @NotBlank(message = "Eircode is required")
    private String eircode;

    @Min(value = 1, message = "Must have at least one occupant")
    private int numberOfOccupants;

    @Min(value = 1, message = "Maximum occupants must be at least 1")
    private int maximumOccupants;

    private boolean ownerOccupied;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Pet> pets;
}