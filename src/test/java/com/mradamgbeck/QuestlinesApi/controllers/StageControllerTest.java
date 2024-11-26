package com.mradamgbeck.QuestlinesApi.controllers;


import com.mradamgbeck.QuestlinesApi.entities.Stage;
import com.mradamgbeck.QuestlinesApi.repositories.StageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StageControllerTest {
    StageController controller;
    @Mock
    StageRepository repo;
    List<Stage> stages = new ArrayList<>();
    Stage stage1;
    Stage stage2;
    Stage stage3;

    @BeforeEach
    public void setup() {
        controller = new StageController(repo);
        stage1 = new Stage("Stage 1", 1);
        stage2 = new Stage("Stage 2", 2);
        stage3 = new Stage("Stage 3", 3);
        stages.add(stage1);
        stages.add(stage2);
        stages.add(stage3);
        when(repo.findAll()).thenReturn(stages);
    }

    @Test
    public void getAll() {
        List<Stage> expectedStages = List.of(stage1, stage2, stage3);
        List<Stage> stages = controller.getAll();
        assertEquals(expectedStages, stages);
    }
}
