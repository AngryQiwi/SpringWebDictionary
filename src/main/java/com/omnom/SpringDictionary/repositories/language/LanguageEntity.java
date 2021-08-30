package com.omnom.SpringDictionary.repositories.language;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omnom.SpringDictionary.repositories.entry.EntryEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "language")
public class LanguageEntity {
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
    private List<EntryEntity> entries;

    public LanguageEntity(long languageId, String languageName, String regexp, List<EntryEntity> entries) {
        this.id = languageId;
        this.languageName = languageName;
        this.regexp = regexp;
        this.entries = entries;
    }

    public LanguageEntity(String languageName, String regexp, List<EntryEntity> entries) {
        this.languageName = languageName;
        this.regexp = regexp;
        this.entries = entries;
    }

    public LanguageEntity() {
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

    public List<EntryEntity> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryEntity> entries) {
        this.entries = entries;
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }
}
