package com.omnom.SpringDictionary.repositories.language;

import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<LanguageEntity, Long> {
    LanguageEntity findByLanguageName(String languageName);
}
