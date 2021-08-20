package com.omnom.SpringDictionary;

import com.omnom.SpringDictionary.entities.Entry;
import com.omnom.SpringDictionary.entities.Language;
import com.omnom.SpringDictionary.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryViewingController {
    private LanguageService languageService;

    @Autowired
    public DictionaryViewingController(LanguageService languageService) {
        this.languageService = languageService;
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

    @GetMapping("/add_entry")
    public String addPage(Model model) {
        return "addEntry";
    }

    @GetMapping("/edit_entry")
    public ModelAndView editPage(@RequestParam("entryId") long id, @RequestParam("key") String original, @RequestParam("value") String translate, @RequestParam("language") long language, Model model) {
        ModelAndView modelAndView = new ModelAndView("addEntry");
        modelAndView.addObject("entry", new Entry(id, original, translate, languageService.findById(id)));
        return modelAndView;
    }

}
