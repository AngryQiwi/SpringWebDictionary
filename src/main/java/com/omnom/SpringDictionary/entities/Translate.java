package com.omnom.SpringDictionary.entities;


import javax.persistence.*;

@Entity
@Table(name = "translates")
public class Translate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "translate_id")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "original_id")
    private Original original;
    @Column(name = "translate_word")
    private String translateWord;

    public Translate() {
    }

    public Translate(long id, Original original, String translateWord) {
        this.id = id;
        this.original = original;
        this.translateWord = translateWord;
    }

    public Translate(Original original, String translateWord) {
        this.original = original;
        this.translateWord = translateWord;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Original getOriginal() {
        return original;
    }

    public void setOriginal(Original original) {
        this.original = original;
    }

    public String getTranslateWord() {
        return translateWord;
    }

    public void setTranslateWord(String translateWord) {
        this.translateWord = translateWord;
    }
}