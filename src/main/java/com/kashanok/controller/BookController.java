package com.kashanok.controller;

import com.kashanok.entity.Book;
import com.kashanok.repository.BookRepository;
import com.kashanok.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/books")
public class BookController extends HttpServlet {

    private BookService bookService = new BookService(new BookRepository());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = bookService.getBooks();

        request.setAttribute("books", books);

        getServletContext().getRequestDispatcher("/books.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);

        bookService.addBook(book);

        getServletContext().getRequestDispatcher("/books.jsp").forward(request, response);
    }
}
