package com.omnom.SpringDictionary.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "original")
public class Original {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "original_id")
    private long id;
    @Column(name = "original_word")
    private String originalWord;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id")
    private Language language;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "original", cascade = CascadeType.ALL)
    private List<Translate> translates;

    public Original() {
    }

    public Original(String originalWord, Language language, List<Translate> translates) {
        this.originalWord = originalWord;
        this.language = language;
        this.translates = translates;
    }

    public Original(long id, String originalWord, Language language, List<Translate> translates) {
        this.id = id;
        this.originalWord = originalWord;
        this.language = language;
        this.translates = translates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Translate> getTranslates() {
        return translates;
    }

    public void setTranslates(List<Translate> translates) {
        this.translates = translates;
    }
}