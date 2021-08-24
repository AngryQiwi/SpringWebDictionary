package com.omnom.SpringDictionary;

import com.omnom.SpringDictionary.entities.Entry;
import com.omnom.SpringDictionary.entities.Language;
import com.omnom.SpringDictionary.services.EntryService;
import com.omnom.SpringDictionary.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Entry> getAllEntries(@RequestParam("language") long language){
        return entryService.findByLanguage(language);
    }
    @GetMapping("/find_entries_in_dictionary")
    public List<Entry> findEntriesInDictionary(@RequestParam("pattern") String pattern, @RequestParam("language") long language){
        return entryService.getEntriesByOriginalOrTranslateInDictionary(pattern, language);
    }
    @GetMapping("/find_entries_anywhere")
    public List<Entry> findEntriesAnywhere(@RequestParam("pattern") String pattern){
        return entryService.getEntriesByOriginalOrTranslateAnywhere(pattern);
    }
    @GetMapping("/get_languages")
    public List<Language> getAllLanguages(){
        return languageService.readAll();
    }
    @DeleteMapping("/delete_entry")
    public void deleteEntry(@RequestParam("entry_id") long entryId){
        entryService.delete(entryId);
    }

    @PutMapping("/upload_entry")
    public void updateEntry(@RequestParam("entry_id") long entryId, @RequestBody EntryHolder entryHolder){
        entryHolder.getEntry().setLanguage(languageService.findById(entryHolder.getLanguageId()));
        entryService.update(entryId, entryHolder.getEntry());
    }
    @PostMapping("/upload_entry")
    public void addEntry(@RequestBody EntryHolder entryHolder){
        entryHolder.getEntry().setLanguage(languageService.findById(entryHolder.getLanguageId()));
        entryService.save(entryHolder.getEntry());
    }
    public static class EntryHolder{
        private Entry entry;
        private Long languageId;

        public EntryHolder(Entry entry, Long languageId) {
            this.entry = entry;
            this.languageId = languageId;
        }

        public Entry getEntry() {
            return entry;
        }

        public void setEntry(Entry entry) {
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
