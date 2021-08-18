package com.omnom.SpringDictionary.services;

import com.omnom.SpringDictionary.repositories.OriginalRepository;
import com.omnom.SpringDictionary.repositories.TranslateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictionaryService {
    private final OriginalRepository originalRepository;
    private final TranslateRepository translateRepository;

    public DictionaryService(OriginalRepository originalRepository, TranslateRepository translateRepository) {
        this.originalRepository = originalRepository;
        this.translateRepository = translateRepository;
    }

}
