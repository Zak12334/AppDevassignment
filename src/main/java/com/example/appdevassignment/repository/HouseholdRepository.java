package com.example.appdevassignment.repository;

import com.example.appdevassignment.entities.Household;
import com.example.appdevassignment.entities.HouseholdStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public interface HouseholdRepository extends JpaRepository<Household, String> {
    @Query("SELECT h FROM Household h LEFT JOIN FETCH h.pets WHERE h.eircode = :eircode")
    Optional<Household> findByEircodeWithPets(@Param("eircode") String eircode);

    @Query("SELECT h FROM Household h WHERE h.pets IS EMPTY")
    List<Household> findHouseholdsWithNoPets();

    @Query("SELECT h FROM Household h WHERE h.ownerOccupied = true")
    List<Household> findOwnerOccupiedHouses();

    @Query("SELECT new map(" +
            "COUNT(CASE WHEN h.numberOfOccupants = 0 THEN 1 ELSE NULL END) as emptyHousesCount, " +
            "COUNT(CASE WHEN h.numberOfOccupants = h.maximumOccupants THEN 1 ELSE NULL END) as fullHousesCount) " +
            "FROM Household h")
    Map<String, Long> getHouseholdStatistics();
}