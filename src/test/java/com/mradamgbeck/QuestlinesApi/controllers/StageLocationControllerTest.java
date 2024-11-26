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

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        when(repo.findAll()).thenReturn(locations);
    }

    @Test
    public void getAll() {
        List<StageLocation> expectedLocations = List.of(stageLocation1, stageLocation2, stageLocation3);
        List<StageLocation> stageLocations = controller.getAll();
        assertEquals(expectedLocations, stageLocations);
    }
}
