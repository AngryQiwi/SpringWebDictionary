package com.omnom.SpringDictionary;

import com.omnom.SpringDictionary.entities.Entry;
import com.omnom.SpringDictionary.services.EntryService;
import com.omnom.SpringDictionary.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class DictionaryViewingController {
    private final LanguageService languageService;
    private final EntryService entryService;

    @Autowired
    public DictionaryViewingController(LanguageService languageService, EntryService entryService) {
        this.languageService = languageService;
        this.entryService = entryService;
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
    public String addPage(@RequestParam long language, HttpSession session) {
        session.setAttribute("entry", null);
        session.setAttribute("language", language);
        return "addEntry";
    }

    @GetMapping("/edit_entry")
    public String editPage(@RequestParam("entryId") long id, @RequestParam("key") String original, @RequestParam("value") String translate, @RequestParam("language") long language, HttpSession session) {
        session.setAttribute("entry", new Entry(id, original, translate, languageService.findById(id)));
        return "addEntry";
    }
}
