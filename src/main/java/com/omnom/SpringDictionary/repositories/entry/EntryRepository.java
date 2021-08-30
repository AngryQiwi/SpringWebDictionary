package com.omnom.SpringDictionary.repositories.entry;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends CrudRepository<EntryEntity, Long> {
    List<EntryEntity> findByLanguageId(long languageId);
    List<EntryEntity> findByOriginalContains(String original);
    List<EntryEntity> findByTranslateContains(String translate);
    List<EntryEntity> findByOriginalContainsAndLanguageId(String pattern, long language);
    List<EntryEntity> findByTranslateContainsAndLanguageId(String pattern, long language);
}
