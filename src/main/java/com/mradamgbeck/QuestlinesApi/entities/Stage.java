package com.mradamgbeck.QuestlinesApi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Stage {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private int priority;
    private boolean selected;
    private boolean complete;
    private Date deadline;
    @ManyToOne
    private Quest quest;
    @OneToMany
    private List<StageLocation> locations;
}
