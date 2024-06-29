package com.challenge.literalura.literalura.service;


import com.challenge.literalura.literalura.model.Book;
import com.challenge.literalura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.literalura.literalura.service.GutendexService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    private GutendexService gutendexService;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> isBookExists(String title) {
        return bookRepository.existsByTitle(title);
    }

    public List<Book> findBooksByLanguage(String languageCode) {
        String url = "https://gutendex.com/books/?search=" + languageCode;
        try {
            return gutendexService.getBooks(url);
        } catch (IOException e) {
            throw new RuntimeException("Error al buscar libros por idioma: " + e.getMessage());
        }
    }


}

