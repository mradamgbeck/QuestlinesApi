package com.mradamgbeck.QuestlinesApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
public class StageLocation {
    @GeneratedValue
    @Id
    private Long id;
    private double latitude;
    private double longitude;
    private boolean complete = false;

    public StageLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

}


