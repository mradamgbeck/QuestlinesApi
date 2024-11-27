package com.mradamgbeck.QuestlinesApi.controllers;

import com.mradamgbeck.QuestlinesApi.entities.StageLocation;
import com.mradamgbeck.QuestlinesApi.repositories.StageLocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/stage-locations/{id}")
    public Optional<StageLocation> findById(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    @PostMapping("/stage-locations")
    public StageLocation saveOne(@RequestBody StageLocation newLocation) {
        return repository.save(newLocation);
    }

    @PutMapping("/stage-locations")
    public StageLocation editOne(@RequestBody StageLocation newLocation){
        return repository.save(newLocation);
    }
}
