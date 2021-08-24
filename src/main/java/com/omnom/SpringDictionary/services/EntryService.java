package com.omnom.SpringDictionary.services;

import com.omnom.SpringDictionary.entities.Entry;
import com.omnom.SpringDictionary.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EntryService {
    private final EntryRepository repository;

    @Autowired
    public EntryService(EntryRepository repository) {
        this.repository = repository;
    }

    public List<Entry> readAll() {
        return repository.findAll();
    }

    public List<Entry> findByLanguage(long language) {
        return repository.findByLanguageId(language);
    }

    public void save(Entry entry) {
        repository.save(entry);
    }

    public void update(long id, Entry entry) {
        if (repository.existsById(id)) {
            entry.setEntryId(id);
            repository.save(entry);
        }
    }

    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.delete(repository.getById(id));
        }
    }

    public List<Entry> getEntriesByOriginalOrTranslateInDictionary(String pattern, long language) {
        List<Entry> fundedEntries;
        fundedEntries = repository.findByOriginalContainsAndLanguageId(pattern, language);
        for (Entry fundedEntry : repository.findByTranslateContainsAndLanguageId(pattern, language)) {
            if(!fundedEntries.contains(fundedEntry)){
                fundedEntries.add(fundedEntry);
            }
        }
        return fundedEntries;
    }
    public List<Entry> getEntriesByOriginalOrTranslateAnywhere(String pattern){
        List<Entry> fundedEntries;
        fundedEntries = repository.findByOriginalContains(pattern);
        fundedEntries.addAll(repository.findByTranslateContains(pattern));
        return fundedEntries;
    }
}
