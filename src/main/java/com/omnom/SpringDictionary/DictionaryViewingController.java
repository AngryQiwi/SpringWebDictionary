package com.omnom.SpringDictionary;

import com.omnom.SpringDictionary.services.OriginalService;
import com.omnom.SpringDictionary.services.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/dictionary/{language}")
    public String dictionaryPage(@PathVariable(name = "language") String language, Model model) {
        model.addAttribute("language", language);
        return "dictionaryView";
    }

    @GetMapping("/addvalue")
    public String addPage(Model model) {
        return "addEntry";
    }

    @GetMapping("/editvalue")
    public String editPage(@RequestParam("key") String key, @RequestParam("value") String value, Model model) {
        model.addAttribute("key", key);
        model.addAttribute("value", value);
        return "addEntry";
    }

}
