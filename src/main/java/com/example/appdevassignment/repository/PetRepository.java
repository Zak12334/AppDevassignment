package com.example.appdevassignment.repository;

import com.example.appdevassignment.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByType(String Type);

    @Modifying
    @Query("DELETE FROM Pet p WHERE LOWER(p.name) = LOWER(:name)")
    void deletePetsByNameIgnoreCase(@Param("name") String name);
}