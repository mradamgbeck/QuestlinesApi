package com.mradamgbeck.QuestlinesApi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Quest {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean selected = false;
    private boolean complete = false;
    private Date created = new Date();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "quest")
    @JsonIgnoreProperties(value = "quest")
    private List<Stage> stages = new ArrayList<>();

    public Quest(String name) {
        this.name = name;
    }

    public void addStage(Stage stage) {
        this.stages.add(stage);
    }

    public void removeStage(Stage stage) {
        this.stages.remove(stage);
    }
}