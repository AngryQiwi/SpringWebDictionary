package com.omnom.SpringDictionary.repositories;

import com.omnom.SpringDictionary.entities.Translate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TranslateRepository extends JpaRepository<Translate, Long> {
    List<Translate> findByOriginalId(long originalId);
    List<Translate> findByTranslateWord(String originalWord);
}
