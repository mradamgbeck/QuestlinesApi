package com.mradamgbeck.QuestlinesApi.controllers;


import com.mradamgbeck.QuestlinesApi.entities.Quest;
import com.mradamgbeck.QuestlinesApi.entities.StageLocation;
import com.mradamgbeck.QuestlinesApi.repositories.QuestRepository;
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
    }

    @Test
    public void getAll() {
        when(repo.findAll()).thenReturn(quests);
        List<Quest> expectedQuests = List.of(quest1, quest2, quest3);
        List<Quest> quests = controller.getAll();
        verify(repo).findAll();
        assertEquals(expectedQuests, quests);
    }

    @Test
    public void findById() {
        long quest1Id = 1L;
        when(repo.findById(quest1Id)).thenReturn(Optional.ofNullable(quest1));
        Optional<Quest> quest = controller.findById(quest1Id);
        verify(repo).findById(quest1Id);
        assertEquals(quest1, quest.get());
    }

    @Test
    public void saveOne() {
        when(repo.save(quest1)).thenReturn(quest1);
        Quest quest = controller.saveOne(quest1);
        verify(repo).save(quest1);
        assertEquals(quest1, quest);
    }

    @Test
    public void editOne() {
        when(repo.save(quest1)).thenReturn(quest1);
        Quest quest = controller.editOne(quest1);
        verify(repo).save(quest1);
        assertEquals(quest1, quest);
    }

    @Test
    public void deleteById() {
        long id = 1L;
        controller.deleteById(id);
        verify(repo).deleteById(id);
    }
}
