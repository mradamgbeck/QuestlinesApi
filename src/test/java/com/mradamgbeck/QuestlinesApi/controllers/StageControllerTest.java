package com.mradamgbeck.QuestlinesApi.controllers;


import com.mradamgbeck.QuestlinesApi.entities.Quest;
import com.mradamgbeck.QuestlinesApi.entities.Stage;
import com.mradamgbeck.QuestlinesApi.entities.StageLocation;
import com.mradamgbeck.QuestlinesApi.repositories.StageLocationRepository;
import com.mradamgbeck.QuestlinesApi.repositories.StageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StageControllerTest {
    StageController controller;
    @Mock
    StageRepository stageRepo;
    @Mock
    StageLocationRepository stageLocationRepo;
    List<Stage> stages = new ArrayList<>();
    Stage stage1;
    Stage stage2;
    Stage stage3;
    private StageLocation location1;

    @BeforeEach
    public void setup() {
        controller = new StageController(stageRepo);
        Quest quest = new Quest("Test Quest");
        stage1 = new Stage("Stage 1", 1, quest);
        stage2 = new Stage("Stage 2", 2, quest);
        stage3 = new Stage("Stage 3", 3, quest);
        location1 = new StageLocation(1.0, 1.0);
        stage1.addLocation(location1);
        stages.add(stage1);
        stages.add(stage2);
        stages.add(stage3);
    }

    @Test
    public void getAll() {
        when(stageRepo.findAll()).thenReturn(stages);
        List<Stage> expectedStages = List.of(stage1, stage2, stage3);
        List<Stage> stages = controller.findAll();
        verify(stageRepo).findAll();
        assertEquals(expectedStages, stages);
    }

    @Test
    public void findById() {
        long stage1Id = 1L;
        when(stageRepo.findById(stage1Id)).thenReturn(Optional.ofNullable(stage1));
        Optional<Stage> stage = controller.findById(stage1Id);
        verify(stageRepo).findById(stage1Id);
        assertEquals(stage1, stage.get());
    }

    @Test
    public void saveOne() {
        when(stageRepo.save(stage1)).thenReturn(stage1);
        Stage stage = controller.saveOne(stage1);
        verify(stageRepo).save(stage1);
        assertEquals(stage1, stage);
    }

    @Test
    public void editOne() {
        when(stageRepo.save(stage1)).thenReturn(stage1);
        Stage stage = controller.editOne(stage1);
        verify(stageRepo).save(stage1);
        assertEquals(stage1, stage);
    }

    @Test
    public void deleteById() {
        long id = 1L;
        controller.deleteById(id);
        verify(stageRepo).deleteById(id);
    }

    @Test
    public void deleteAll() {
        controller.deleteAll();
        verify(stageRepo).deleteAll();
    }
}
