package com.mradamgbeck.QuestlinesApi.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
//    @ManyToOne
//    @JoinColumn(name = "quest_id", nullable = false)
//    private Quest quest;
//    @OneToMany
//    private List<StageLocation> locations = new ArrayList<StageLocation>();

    public Stage(String name, int priority){
        this.name = name;
        this.priority = priority;
    }

    public Stage(String name, int priority, Date deadline){
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }
}
