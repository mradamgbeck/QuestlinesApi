package com.mradamgbeck.QuestlinesApi.controllers;

import com.mradamgbeck.QuestlinesApi.entities.StageLocation;
import com.mradamgbeck.QuestlinesApi.repositories.StageLocationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StageLocationController {
    private final StageLocationRepository repository;

    public StageLocationController(StageLocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/stage-locations")
    public List<StageLocation> getAll() {
        return repository.findAll();
    }
}
