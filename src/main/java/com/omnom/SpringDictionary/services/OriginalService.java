package com.omnom.SpringDictionary.services;

import com.omnom.SpringDictionary.entities.Language;
import com.omnom.SpringDictionary.entities.Original;
import com.omnom.SpringDictionary.repositories.OriginalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OriginalService {
    private final OriginalRepository repository;

    @Autowired
    public OriginalService(OriginalRepository repository) {
        this.repository = repository;
    }

    public List<Original> readAll(Language language) {
        return repository.findByLanguage(language);
    }

    public Original findInDictionary(String word, String language) {
        return repository.findByOriginalWordInDictionary(word, language);
    }
    public List<Original> findAnywhere(String word){
        return repository.findByOriginalWord(word);
    }

    public void save(Original original) {
        repository.save(original);
    }

    public void update(long id, Original original) {
        if (repository.existsById(id)) {
            original.setId(id);
            repository.save(original);
        }
    }

    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.delete(repository.getById(id));
        }
    }
}
