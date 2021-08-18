package com.omnom.SpringDictionary;

import com.omnom.SpringDictionary.services.OriginalService;
import com.omnom.SpringDictionary.services.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DictionaryViewingController {
    private final OriginalService originalService;
    private final TranslateService translateService;

    @Autowired
    public DictionaryViewingController(OriginalService originalService, TranslateService translateService) {
        this.originalService = originalService;
        this.translateService = translateService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }
}
