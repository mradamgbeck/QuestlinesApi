package com.mradamgbeck.QuestlinesApi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
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
    @Nullable
    private Date deadline;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quest_id", nullable = false)
    @JsonIgnoreProperties(value="stages")
    private Quest quest;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "STAGE_LOCATION_ID")
    private List<StageLocation> locations = new ArrayList<>();

    public Stage(String name, int priority, Quest quest) {
        this.name = name;
        this.priority = priority;
        this.quest = quest;
    }

    public Stage(String name, int priority, Quest quest, Date deadline) {
        this.name = name;
        this.priority = priority;
        this.quest = quest;
        this.deadline = deadline;
    }

    public void addLocation(StageLocation location) {
        this.locations.add(location);
    }

    public void removeLocation(StageLocation location) {
        this.locations.remove(location);
    }
}
