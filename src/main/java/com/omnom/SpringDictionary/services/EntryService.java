package com.omnom.SpringDictionary.services;

import com.omnom.SpringDictionary.entities.Entry;
import com.omnom.SpringDictionary.repositories.EntryRepository;
import com.omnom.SpringDictionary.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EntryService {
    private final EntryRepository entryRepository;

    @Autowired
    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<Entry> readAll() {
        return entryRepository.findAll();
    }

    public List<Entry> findByLanguage(long language) {
        return entryRepository.findByLanguageId(language);
    }

    public boolean save(Entry entry) {
        String regex = entry.getLanguage().getRegexp();
        if(entry.getOriginal().matches(regex) && !entry.getTranslate().isEmpty()){
            entryRepository.save(entry);
            return true;
        }
        return false;
    }

    public boolean update(long id, Entry entry) {
        String regex = entry.getLanguage().getRegexp();
        if (entryRepository.existsById(id) && entry.getOriginal().matches(regex) && !entry.getTranslate().isEmpty()) {
            entry.setEntryId(id);
            entryRepository.save(entry);
            return true;
        }
        return false;
    }

    public void delete(long id) {
        if (entryRepository.existsById(id)) {
            entryRepository.delete(entryRepository.getById(id));
        }
    }

    public List<Entry> getEntriesByOriginalOrTranslateInDictionary(String pattern, long language) {
        List<Entry> fundedEntries;
        fundedEntries = entryRepository.findByOriginalContainsAndLanguageId(pattern, language);
        for (Entry fundedEntry : entryRepository.findByTranslateContainsAndLanguageId(pattern, language)) {
            if(!fundedEntries.contains(fundedEntry)){
                fundedEntries.add(fundedEntry);
            }
        }
        return fundedEntries;
    }
    public List<Entry> getEntriesByOriginalOrTranslateAnywhere(String pattern){
        List<Entry> fundedEntries;
        fundedEntries = entryRepository.findByOriginalContains(pattern);
        fundedEntries.addAll(entryRepository.findByTranslateContains(pattern));
        return fundedEntries;
    }
}
