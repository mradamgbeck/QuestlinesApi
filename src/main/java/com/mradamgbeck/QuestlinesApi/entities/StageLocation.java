package com.mradamgbeck.QuestlinesApi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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


