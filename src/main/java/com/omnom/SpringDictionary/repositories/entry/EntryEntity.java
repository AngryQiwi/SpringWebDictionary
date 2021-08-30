package com.omnom.SpringDictionary.repositories.entry;

import com.omnom.SpringDictionary.repositories.language.LanguageEntity;

import javax.persistence.*;
@Entity
@Table(name = "entry")
public class EntryEntity {
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
    private LanguageEntity language;

    public EntryEntity(long entryId, String original, String translate, LanguageEntity language) {
        this.entryId = entryId;
        this.original = original;
        this.translate = translate;
        this.language = language;
    }

    public EntryEntity(String original, String translate, LanguageEntity language) {
        this.original = original;
        this.translate = translate;
        this.language = language;
    }

    public EntryEntity(String original, String translate) {
        this.original = original;
        this.translate = translate;
    }

    public EntryEntity() {
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

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
