package com.omnom.SpringDictionary.repositories;

import com.omnom.SpringDictionary.entities.Original;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OriginalRepository extends JpaRepository<Original, Long> {
    List<Original> findByLanguage(String language);
    List<Original> findByOriginalWord(String originalWord);
    @Query("select o from Original o where o.originalWord = :originalWord and o.language = :language")
    Original findByOriginalWordInDictionary(@Param("originalWord") String originalWord, @Param("language") String language);
}
