package com.kashanok.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/test_r")
public class MyServlet extends HttpServlet {

    public static final String COOKIE = "MyCookies";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("name", "Vasya");
        request.setAttribute("age", 25);

        Cookie cookie = new Cookie(COOKIE, "Test_string_information");

        response.addCookie(cookie);

        getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
    }
}