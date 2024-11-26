package com.mradamgbeck.QuestlinesApi.controllers;

import com.mradamgbeck.QuestlinesApi.entities.Quest;
import com.mradamgbeck.QuestlinesApi.repositories.QuestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestController {
    private final QuestRepository repository;

    QuestController(QuestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/quests")
    List<Quest> getAll() {
        return repository.findAll();
    }

    @GetMapping("/quests/{id}")
    public Optional<Quest> findById(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    @PostMapping("/quests")
    public Quest saveOne(@RequestBody Quest quest) {
        return repository.save(quest);
    }
}
