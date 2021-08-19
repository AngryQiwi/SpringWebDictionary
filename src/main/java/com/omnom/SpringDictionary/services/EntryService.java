package com.omnom.SpringDictionary.services;

import com.omnom.SpringDictionary.entities.Entry;
import com.omnom.SpringDictionary.entities.Original;
import com.omnom.SpringDictionary.entities.Translate;
import com.omnom.SpringDictionary.repositories.OriginalRepository;
import com.omnom.SpringDictionary.repositories.TranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EntryService {
    private final OriginalRepository originalRepository;
    private final TranslateRepository translateRepository;
    @Autowired
    public EntryService(OriginalRepository originalRepository, TranslateRepository translateRepository) {
        this.originalRepository = originalRepository;
        this.translateRepository = translateRepository;
    }

}
