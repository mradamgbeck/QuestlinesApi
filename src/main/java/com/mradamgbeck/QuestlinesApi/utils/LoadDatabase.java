package com.mradamgbeck.QuestlinesApi.utils;

import com.mradamgbeck.QuestlinesApi.entities.Quest;
import com.mradamgbeck.QuestlinesApi.entities.Stage;
import com.mradamgbeck.QuestlinesApi.entities.StageLocation;
import com.mradamgbeck.QuestlinesApi.repositories.QuestRepository;
import com.mradamgbeck.QuestlinesApi.repositories.StageLocationRepository;
import com.mradamgbeck.QuestlinesApi.repositories.StageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(QuestRepository questRepository, StageRepository stageRepository, StageLocationRepository stageLocationRepository) {
        Quest quest1 = new Quest("Test Quest 1");
        Quest quest2 = new Quest("Test Quest 2");
        Quest quest3 = new Quest("Test Quest 3");
        Stage stage1 = new Stage("Test Stage 1", 0, new Date(System.currentTimeMillis() + System.currentTimeMillis() / 10));
        Stage stage2 = new Stage("Test Stage 2", 0, new Date(System.currentTimeMillis() + System.currentTimeMillis() / 10));
        Stage stage3 = new Stage("Test Stage 3", 0, new Date(System.currentTimeMillis() + System.currentTimeMillis() / 10));
        StageLocation location1 = new StageLocation(1.0, 1.0);
        StageLocation location2 = new StageLocation(2.0, 2.0);
        StageLocation location3 = new StageLocation(3.0, 3.0);
        return args -> {
            log.info("Creating Test StageLocation " + stageLocationRepository.save(location1));
            log.info("Creating Test StageLocation " + stageLocationRepository.save(location2));
            log.info("Creating Test StageLocation " + stageLocationRepository.save(location3));
            log.info("Creating Test Stage " + stageRepository.save(stage1));
            log.info("Creating Test Stage " + stageRepository.save(stage2));
            log.info("Creating Test Stage " + stageRepository.save(stage3));
            log.info("Creating Test Quest " + questRepository.save(quest1));
            log.info("Creating Test Quest " + questRepository.save(quest2));
            log.info("Creating Test Quest " + questRepository.save(quest3));
        };
    }
}