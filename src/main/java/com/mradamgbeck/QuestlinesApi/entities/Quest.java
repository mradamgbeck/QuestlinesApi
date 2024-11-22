package com.mradamgbeck.QuestlinesApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
class Quest {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean selected;
    private boolean complete;
    private Date created;
    @OneToMany
    private List<Stage> stages;
}