package com.omnom.SpringDictionary.services;

import com.omnom.SpringDictionary.entities.Translate;
import com.omnom.SpringDictionary.repositories.TranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TranslateService {
    @Autowired
    private TranslateRepository repository;

    public List<Translate> readAll() {
        return repository.findAll();
    }

    public Translate readById(long id) {
        return repository.getById(id);
    }

    public List<Translate> readByTranslateWord(String word) {
        return repository.findByTranslateWord(word);
    }

    public void save(Translate translate) {
        repository.save(translate);
    }

    public void update(long id, Translate translate) {
        if (repository.existsById(id)) {
            translate.setId(id);
            repository.save(translate);
        }
    }

    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.delete(repository.getById(id));
        }
    }
}
