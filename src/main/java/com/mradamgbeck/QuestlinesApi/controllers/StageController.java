package com.mradamgbeck.QuestlinesApi.controllers;

import com.mradamgbeck.QuestlinesApi.entities.Stage;
import com.mradamgbeck.QuestlinesApi.repositories.StageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StageController {
    private final StageRepository repository;

    StageController(StageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/stages")
    List<Stage> getAll() {
        return repository.findAll();
    }
}
