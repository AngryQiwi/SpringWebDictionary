package com.omnom.SpringDictionary.services;

import com.omnom.SpringDictionary.repositories.entry.EntryEntity;
import com.omnom.SpringDictionary.repositories.entry.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntryService {
    private final EntryRepository entryRepository;
    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<EntryEntity> findAll() {
        return (List<EntryEntity>) entryRepository.findAll();
    }

    public List<EntryEntity> findByLanguage(long language) {
        return entryRepository.findByLanguageId(language);
    }

    public boolean save(EntryEntity entry) {
        String regex = entry.getLanguage().getRegexp();
        if(entry.getOriginal().matches(regex) && !entry.getTranslate().isEmpty()){
            entryRepository.save(entry);
            return true;
        }
        return false;
    }

    public boolean update(EntryEntity entry) {
        String regex = entry.getLanguage().getRegexp();
        if (entryRepository.existsById(entry.getEntryId()) && entry.getOriginal().matches(regex) && !entry.getTranslate().isEmpty()) {
            entry.setEntryId(entry.getEntryId());
            entryRepository.save(entry);
            return true;
        }
        return false;
    }

    public void delete(long id) {
        entryRepository.deleteById(id);
    }

    public List<EntryEntity> findEntriesByOriginalOrTranslateInDictionary(String pattern, long language) {
        List<EntryEntity> fundedEntries;
        fundedEntries = entryRepository.findByOriginalContainsAndLanguageId(pattern, language);
        for (EntryEntity fundedEntry : entryRepository.findByTranslateContainsAndLanguageId(pattern, language)) {
            if(!fundedEntries.contains(fundedEntry)){
                fundedEntries.add(fundedEntry);
            }
        }
        return fundedEntries;
    }
    public List<EntryEntity> findEntriesByOriginalOrTranslateAnywhere(String pattern){
        List<EntryEntity> fundedEntries;
        fundedEntries = entryRepository.findByOriginalContains(pattern);
        fundedEntries.addAll(entryRepository.findByTranslateContains(pattern));
        return fundedEntries;
    }
}
