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
public class Stage {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private int priority = 0;
    private boolean selected = false;
    private boolean complete = false;
    private Date deadline;
    @Column(name = "quest_id")
    private Long questId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stage_id")
    private List<StageLocation> locations = new ArrayList<>();

    public Stage(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public Stage(String name, int priority, Date deadline) {
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    public void addLocation(StageLocation location) {
        this.locations.add(location);
    }

    public void removeLocation(StageLocation location) {
        this.locations.remove(location);
    }

}
