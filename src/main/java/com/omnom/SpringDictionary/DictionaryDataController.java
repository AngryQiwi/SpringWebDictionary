package com.omnom.SpringDictionary;

import com.omnom.SpringDictionary.entities.Entry;
import com.omnom.SpringDictionary.entities.Language;
import com.omnom.SpringDictionary.entities.Original;
import com.omnom.SpringDictionary.entities.Translate;
import com.omnom.SpringDictionary.services.LanguageService;
import com.omnom.SpringDictionary.services.OriginalService;
import com.omnom.SpringDictionary.services.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DictionaryDataController {
    private final OriginalService originalService;
    private final TranslateService translateService;
    private final LanguageService languageService;
    @Autowired
    public DictionaryDataController(OriginalService originalService, TranslateService translateService, LanguageService languageService) {
        this.originalService = originalService;
        this.translateService = translateService;
        this.languageService = languageService;
    }

    @GetMapping("/get_entries")
    public List<Entry> getAllEntries(@RequestParam("language") String languageStr){
        List<Entry> entries = new ArrayList<>();
        Language language = languageService.findByLanguageName(languageStr);
        List<Original> originals = originalService.readAll(language);
        for (Original original : originals) {
            List<Translate> translates = original.getTranslates();
            for (Translate translate : translates) {
                entries.add(new Entry(original.getOriginalWord(), translate.getTranslateWord()));
            }
        }
        return entries;
    }
}
