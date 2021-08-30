package com.omnom.SpringDictionary;

import com.omnom.SpringDictionary.repositories.entry.EntryEntity;
import com.omnom.SpringDictionary.repositories.language.LanguageEntity;
import com.omnom.SpringDictionary.services.EntryService;
import com.omnom.SpringDictionary.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DictionaryDataController {
    private final EntryService entryService;
    private final LanguageService languageService;
    @Autowired
    public DictionaryDataController(EntryService entryService, LanguageService languageService) {
        this.entryService = entryService;
        this.languageService = languageService;
    }

    @GetMapping("/get_entries")
    public List<EntryEntity> getAllEntries(@RequestParam("language") long language){
        return entryService.findByLanguage(language);
    }
    @GetMapping("/find_entries_in_dictionary")
    public List<EntryEntity> findEntriesInDictionary(@RequestParam("pattern") String pattern, @RequestParam("language") long language){
        return entryService.findEntriesByOriginalOrTranslateInDictionary(pattern, language);
    }
    @GetMapping("/find_entries_anywhere")
    public List<EntryEntity> findEntriesAnywhere(@RequestParam("pattern") String pattern){
        return entryService.findEntriesByOriginalOrTranslateAnywhere(pattern);
    }
    @GetMapping("/get_languages")
    public List<LanguageEntity> getAllLanguages(){
        return languageService.findAll();
    }
    @DeleteMapping("/delete_entry")
    public void deleteEntry(@RequestParam("entry_id") long entryId){
        entryService.delete(entryId);
    }

    @PutMapping("/upload_entry")
    public ResponseEntity<?> updateEntry(@RequestBody EntryHolder entryHolder){
        entryHolder.getEntry().setLanguage(languageService.findById(entryHolder.getLanguageId()));
        return entryService.update(entryHolder.getEntry()) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/upload_entry")
    public ResponseEntity<?> addEntry(@RequestBody EntryHolder entryHolder){
        entryHolder.getEntry().setLanguage(languageService.findById(entryHolder.getLanguageId()));
        return entryService.save(entryHolder.getEntry()) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    public static class EntryHolder{
        private EntryEntity entry;
        private Long languageId;

        public EntryHolder(EntryEntity entry, Long languageId) {
            this.entry = entry;
            this.languageId = languageId;
        }

        public EntryEntity getEntry() {
            return entry;
        }

        public void setEntry(EntryEntity entry) {
            this.entry = entry;
        }

        public Long getLanguageId() {
            return languageId;
        }

        public void setLanguageId(Long languageId) {
            this.languageId = languageId;
        }
    }
}
