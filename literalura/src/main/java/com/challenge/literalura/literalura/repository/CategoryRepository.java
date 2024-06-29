package com.challenge.literalura.literalura.repository;

import com.challenge.literalura.literalura.model.Author;
import com.challenge.literalura.literalura.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT DISTINCT b.category FROM Book b")
    List<Category> findAllCategories();

    @Query("SELECT COUNT(bc) FROM BookCategory bc WHERE bc.category.name = :categoryName")
    long countBooksByCategoryName(String categoryName);

    Optional<Category> findByName(String name);

    void deleteByName(String name);

}