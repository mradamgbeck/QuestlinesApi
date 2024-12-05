package com.mradamgbeck.QuestlinesApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @Column(name = "stage_id")
    private Long stageId;

    public StageLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}


