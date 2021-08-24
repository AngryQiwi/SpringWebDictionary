package com.omnom.SpringDictionary.entities;

import javax.persistence.*;
@Entity
@Table
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private Long entryId;
    @Column(name = "original")
    private String original;
    @Column(name = "translate")
    private String translate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "language_id")
    private Language language;

    public Entry(long entryId, String original, String translate, Language language) {
        this.entryId = entryId;
        this.original = original;
        this.translate = translate;
        this.language = language;
    }

    public Entry(String original, String translate, Language language) {
        this.original = original;
        this.translate = translate;
        this.language = language;
    }

    public Entry(String original, String translate) {
        this.original = original;
        this.translate = translate;
    }

    public Entry() {
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
