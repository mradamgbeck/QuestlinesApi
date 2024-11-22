package com.mradamgbeck.QuestlinesApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StageLocation {
    @GeneratedValue
    @Id
    private Long id;
    private double latitude;
    private double longitude;
    private boolean complete;
}
