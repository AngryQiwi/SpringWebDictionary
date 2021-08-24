package com.omnom.SpringDictionary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long id;
    @Column(name = "language_name")
    private String languageName;
    @Column(name = "regexp")
    private String regexp;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "language", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Entry> entries;

    public Language(long languageId, String languageName, String regexp, List<Entry> entries) {
        this.id = languageId;
        this.languageName = languageName;
        this.regexp = regexp;
        this.entries = entries;
    }

    public Language(String languageName, String regexp, List<Entry> entries) {
        this.languageName = languageName;
        this.regexp = regexp;
        this.entries = entries;
    }

    public Language() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }
}
