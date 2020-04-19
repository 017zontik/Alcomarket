package com.kashanok.service;

import com.kashanok.entity.Book;
import com.kashanok.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        List<Book> books = bookRepository.getBooks().stream().map(it -> {
            it.setTitle(it.getTitle().toUpperCase());
            return it;
        }).collect(Collectors.toList());
        return books;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }
}
