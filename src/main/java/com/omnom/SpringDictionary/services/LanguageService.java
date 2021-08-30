package com.omnom.SpringDictionary.services;

import com.omnom.SpringDictionary.repositories.language.LanguageEntity;
import com.omnom.SpringDictionary.repositories.language.LanguageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LanguageService {
    private final LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    public List<LanguageEntity> findAll() {
        return (List<LanguageEntity>) repository.findAll();
    }

    public LanguageEntity findByLanguageName(String language) {
        return repository.findByLanguageName(language);
    }

    public void save(LanguageEntity language) {
        repository.save(language);
    }

    public void update(long id, LanguageEntity language) {
        if (repository.existsById(id)) {
            language.setId(id);
            repository.save(language);
        }
    }
    public LanguageEntity findById(long id){
        return repository.findById(id).orElse(null);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
}
