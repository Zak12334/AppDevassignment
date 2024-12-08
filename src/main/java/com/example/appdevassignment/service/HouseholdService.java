package com.example.appdevassignment.service;

import com.example.appdevassignment.dtos.HouseholdRequestDTO;
import com.example.appdevassignment.entities.Household;
import com.example.appdevassignment.repository.HouseholdRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    @Transactional
    public Household createHousehold(HouseholdRequestDTO dto) {
        Household household = new Household();
        household.setEircode(dto.eircode());
        household.setNumberOfOccupants(dto.numberOfOccupants());
        household.setMaximumOccupants(dto.maximumOccupants());
        household.setOwnerOccupied(dto.ownerOccupied());
        validateHousehold(household);
        return householdRepository.save(household);
    }

    public List<Household> findAll() {
        return householdRepository.findAll();
    }

    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }

    @Transactional(readOnly = true)
    public Household getHousehold(String eircode) {
        return householdRepository.findById(eircode)
                .orElseThrow(() -> new EntityNotFoundException("Household not found: " + eircode));
    }

    @Transactional(readOnly = true)
    public Household getHouseholdWithPets(String eircode) {
        return householdRepository.findByEircodeWithPets(eircode)
                .orElseThrow(() -> new EntityNotFoundException("Household not found: " + eircode));
    }

    @Transactional
    public void deleteHousehold(String eircode) {
        Household household = getHousehold(eircode);
        householdRepository.delete(household);
    }

    @Transactional
    public Household updateHousehold(String eircode, HouseholdRequestDTO dto) {
        Household household = getHousehold(eircode);
        household.setNumberOfOccupants(dto.numberOfOccupants());
        household.setMaximumOccupants(dto.maximumOccupants());
        household.setOwnerOccupied(dto.ownerOccupied());
        validateHousehold(household);
        return householdRepository.save(household);
    }

    public List<Household> getOwnerOccupiedHouses() {
        return householdRepository.findOwnerOccupiedHouses();
    }

    public Map<String, Long> getStatistics() {
        return householdRepository.getHouseholdStatistics();
    }

    private void validateHousehold(Household household) {
        if (household.getNumberOfOccupants() > household.getMaximumOccupants()) {
            throw new IllegalArgumentException("Number of occupants cannot exceed maximum occupants");
        }
    }
}