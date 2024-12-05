package com.mradamgbeck.QuestlinesApi.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Quest {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean selected = false;
    private boolean complete = false;
    private Date created = new Date();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "quest_id")
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