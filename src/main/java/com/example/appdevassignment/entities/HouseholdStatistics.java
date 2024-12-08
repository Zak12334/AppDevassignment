package com.example.appdevassignment.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseholdStatistics {
    private Long emptyHousesCount;
    private Long fullHousesCount;

}
