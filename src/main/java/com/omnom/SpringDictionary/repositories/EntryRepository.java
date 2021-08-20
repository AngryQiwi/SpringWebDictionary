package com.omnom.SpringDictionary.repositories;

import com.omnom.SpringDictionary.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByLanguageId(long languageId);
    List<Entry> findByOriginalContains(String original);
    List<Entry> findByTranslateContains(String translate);
    List<Entry> findByOriginalContainsAndLanguage(String original, String language);
    List<Entry> findByTranslateContainsAndLanguage(String translate, String language);
}
