package com.omnom.SpringDictionary.repositories;

import com.omnom.SpringDictionary.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByLanguageName(String languageName);
}
