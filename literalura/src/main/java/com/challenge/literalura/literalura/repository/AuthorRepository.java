package com.challenge.literalura.literalura.repository;

import com.challenge.literalura.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByLastName(String lastName);

    @Query("SELECT DISTINCT b.author FROM Book b")
    List<Author> findAllAuthors();

    @Query("SELECT DISTINCT b.author FROM Book b WHERE b.author.birthYear <= :year AND (b.author.deathYear IS NULL OR b.author.deathYear > :year)")
    List<Author> findAuthorsAliveInYear(int year);

    Optional<Author> findByName(String name);



}