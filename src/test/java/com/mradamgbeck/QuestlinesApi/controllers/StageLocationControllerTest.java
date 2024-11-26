package com.mradamgbeck.QuestlinesApi.controllers;


import com.mradamgbeck.QuestlinesApi.entities.StageLocation;
import com.mradamgbeck.QuestlinesApi.repositories.StageLocationRepository;
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
public class StageLocationControllerTest {
    StageLocationController controller;
    @Mock
    StageLocationRepository repo;

    public static final double LATITUDE1 = 1.0;
    public static final double LATITUDE2 = 2.0;
    public static final double LATITUDE3 = 3.0;
    public static final double LONGITUDE1 = 1.0;
    public static final double LONGITUDE2 = 2.0;
    public static final double LONGITUDE3 = 3.0;
    List<StageLocation> locations = new ArrayList<StageLocation>();
    StageLocation stageLocation1;
    StageLocation stageLocation2;
    StageLocation stageLocation3;

    @BeforeEach
    public void setup() {
        controller = new StageLocationController(repo);
        stageLocation1 = new StageLocation(LATITUDE1, LONGITUDE1);
        stageLocation2 = new StageLocation(LATITUDE2, LONGITUDE2);
        stageLocation3 = new StageLocation(LATITUDE3, LONGITUDE3);
        locations.add(stageLocation1);
        locations.add(stageLocation2);
        locations.add(stageLocation3);
    }

    @Test
    public void findAll() {
        when(repo.findAll()).thenReturn(locations);
        List<StageLocation> expectedLocations = List.of(stageLocation1, stageLocation2, stageLocation3);
        List<StageLocation> stageLocations = controller.getAll();
        verify(repo).findAll();
        assertEquals(expectedLocations, stageLocations);
    }

    @Test
    public void findById() {
        long stageLocation1Id = 1L;
        when(repo.findById(stageLocation1Id)).thenReturn(Optional.ofNullable(stageLocation1));
        Optional<StageLocation> stageLocations = controller.findById(stageLocation1Id);
        verify(repo).findById(stageLocation1Id);
        assertEquals(stageLocation1, stageLocations.get());
    }

    @Test
    public void saveOne() {
        when(repo.save(stageLocation1)).thenReturn(stageLocation1);
        StageLocation stageLocation = controller.saveOne(stageLocation1);
        verify(repo).save(stageLocation1);
        assertEquals(stageLocation1, stageLocation);
    }
}
