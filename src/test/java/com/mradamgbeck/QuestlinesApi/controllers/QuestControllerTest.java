package com.mradamgbeck.QuestlinesApi.controllers;


import com.mradamgbeck.QuestlinesApi.entities.Quest;
import com.mradamgbeck.QuestlinesApi.repositories.QuestRepository;
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
public class QuestControllerTest {
    QuestController controller;
    @Mock
    QuestRepository repo;
    List<Quest> quests = new ArrayList<>();
    Quest quest1;
    Quest quest2;
    Quest quest3;

    @BeforeEach
    public void setup() {
        controller = new QuestController(repo);
        quest1 = new Quest("quest 1");
        quest2 = new Quest("quest 2");
        quest3 = new Quest("quest 3");
        quests.add(quest1);
        quests.add(quest2);
        quests.add(quest3);
        when(repo.findAll()).thenReturn(quests);
    }

    @Test
    public void getAll() {
        List<Quest> expectedQuests = List.of(quest1, quest2, quest3);
        List<Quest> quests = controller.getAll();
        assertEquals(expectedQuests, quests);
    }
}
