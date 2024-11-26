package com.mradamgbeck.QuestlinesApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
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
//    @OneToMany(mappedBy = "quest")
//    private List<Stage> stages = new ArrayList<Stage>();

    public Quest(String name){
        this.name = name;
    }

//    public void addStage(Stage stage){
//        this.stages.add(stage);
//    }
}