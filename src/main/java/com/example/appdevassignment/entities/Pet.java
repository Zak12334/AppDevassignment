package com.example.appdevassignment.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Pet name is required")
    private String name;

    @NotBlank(message = "Breed is required")
    private String breed;

    @NotBlank(message = "Type is required")
    private String type;

    @Min(value = 0, message = "Age cannot be negative")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_eircode", nullable = false)
    private Household household;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String someField;
}