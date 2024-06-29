package com.challenge.literalura.literalura.repository;


import com.challenge.literalura.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();

    Optional<Book> findByTitle(String title);

    List<Book> findByLanguageCode(String languageCode);

    List<Book> existsByTitle(String title);

}

