package com.mradamgbeck.QuestlinesApi.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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
