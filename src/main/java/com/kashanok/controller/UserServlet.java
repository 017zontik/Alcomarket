package com.kashanok.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("name", "WOOHOO");
        request.setAttribute("age", 33);

        getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));

        name = name + " WAS IN SERVLET";
        age = age + 100;

        request.setAttribute("name", name);
        request.setAttribute("age", age);

        getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
    }
}
