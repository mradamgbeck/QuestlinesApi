package com.mradamgbeck.QuestlinesApi.controllers;

import com.mradamgbeck.QuestlinesApi.entities.Stage;
import com.mradamgbeck.QuestlinesApi.entities.StageLocation;
import com.mradamgbeck.QuestlinesApi.repositories.StageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StageController {
    private final StageRepository repository;

    StageController(StageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/stages")
    List<Stage> findAll() {
        return repository.findAll();
    }

    @GetMapping("/stages/{id}")
    public Optional<Stage> findById(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    @PostMapping("stages")
    public Stage saveOne(@RequestBody Stage stage) {
        return repository.save(stage);
    }

    @PutMapping("/stages")
    public Stage editOne(@RequestBody Stage newStage){
        return repository.save(newStage);
    }

    @DeleteMapping("/stages/{id}")
    void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/stages")
    void deleteAll() {
        repository.deleteAll();
    }
}
