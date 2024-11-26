package com.mradamgbeck.QuestlinesApi.repositories;

import com.mradamgbeck.QuestlinesApi.entities.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest, Long> {

}