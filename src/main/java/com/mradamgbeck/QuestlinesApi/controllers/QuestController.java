package com.mradamgbeck.QuestlinesApi.controllers;

import com.mradamgbeck.QuestlinesApi.entities.Quest;
import com.mradamgbeck.QuestlinesApi.repositories.QuestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
