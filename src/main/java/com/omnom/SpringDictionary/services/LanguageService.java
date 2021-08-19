package com.omnom.SpringDictionary.services;

import com.omnom.SpringDictionary.entities.Language;
import com.omnom.SpringDictionary.entities.Original;
import com.omnom.SpringDictionary.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageService {
    private final LanguageRepository repository;
    @Autowired
    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }
    public List<Language> readAll() {
        return repository.findAll();
    }

    public Language findByLanguageName(String language) {
        return repository.findByLanguageName(language);
    }

    public void save(Language language) {
        repository.save(language);
    }

    public void update(long id, Language language) {
        if (repository.existsById(id)) {
            language.setId(id);
            repository.save(language);
        }
    }

    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.delete(repository.getById(id));
        }
    }
}
