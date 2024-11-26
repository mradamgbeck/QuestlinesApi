package com.mradamgbeck.QuestlinesApi.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class StageLocationTest {

    StageLocation stageLocation;

    @Test
    public void testLombokStillWorks() {
        double latitude = 1.0;
        double longitude = 2.0;
        stageLocation = new StageLocation(latitude, longitude);
        stageLocation.setComplete(true);
        assertEquals(latitude, stageLocation.getLatitude());
        assertEquals(longitude, stageLocation.getLongitude());
        assertTrue(stageLocation.isComplete());
    }
}