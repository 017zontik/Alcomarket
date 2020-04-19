package com.kashanok.repository;

import com.kashanok.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    List<Book> booksList = new ArrayList<>();


    public void addBook(Book book) {
        booksList.add(book);
    }

    public List<Book> getBooks() {
        return booksList;
    }


}
