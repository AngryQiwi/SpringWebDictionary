package com.omnom.SpringDictionary.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private long id;
    @Column(name = "language_name")
    private String languageName;
    @Column(name = "regexp")
    private String regexp;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "language", cascade = CascadeType.ALL)
    private List<Original> originals;

    public Language(long languageId, String languageName, String regexp, List<Original> originals) {
        this.id = languageId;
        this.languageName = languageName;
        this.regexp = regexp;
        this.originals = originals;
    }

    public Language(String languageName, String regexp, List<Original> originals) {
        this.languageName = languageName;
        this.regexp = regexp;
        this.originals = originals;
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

    public List<Original> getOriginals() {
        return originals;
    }

    public void setOriginals(List<Original> originals) {
        this.originals = originals;
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }
}
