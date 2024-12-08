package com.example.appdevassignment.controllers;
import com.example.appdevassignment.dtos.HouseholdRequestDTO;
import com.example.appdevassignment.entities.Household;
import com.example.appdevassignment.service.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/households")
@RequiredArgsConstructor
public class HouseholdController {
    private final HouseholdService householdService;

    @GetMapping
    public ResponseEntity<List<Household>> getAllHouseholds() {
        return ResponseEntity.ok(householdService.findAll());
    }

    @GetMapping("/no-pets")
    public ResponseEntity<List<Household>> getHouseholdsWithNoPets() {
        return ResponseEntity.ok(householdService.findHouseholdsWithNoPets());
    }

    @GetMapping("/owner-occupied")
    public ResponseEntity<List<Household>> getOwnerOccupiedHouses() {
        return ResponseEntity.ok(householdService.getOwnerOccupiedHouses());
    }

    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Long>> getStatistics() {
        return ResponseEntity.ok(householdService.getStatistics());
    }

    @GetMapping("/{eircode}")
    public ResponseEntity<Household> getByEircode(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.getHousehold(eircode));
    }

    @GetMapping("/{eircode}/with-pets")
    public ResponseEntity<Household> getByEircodeWithPets(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.getHouseholdWithPets(eircode));
    }

    @PostMapping
    public ResponseEntity<Household> create(@Valid @RequestBody HouseholdRequestDTO householdDTO) {
        return ResponseEntity.ok(householdService.createHousehold(householdDTO));
    }

    @PutMapping("/{eircode}")
    public ResponseEntity<Household> update(
            @PathVariable String eircode,
            @Valid @RequestBody HouseholdRequestDTO dto) {
        return ResponseEntity.ok(householdService.updateHousehold(eircode, dto));
    }

    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHousehold(eircode);
        return ResponseEntity.noContent().build();
    }
}