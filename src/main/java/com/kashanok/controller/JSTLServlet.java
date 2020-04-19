package com.kashanok.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/jstl")
public class JSTLServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> names = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            names.add("Name " + i);
        }
        request.setAttribute("names", names);
        request.setAttribute("namesVisible", true);

        request.setAttribute("name", "Vasya");
        request.setAttribute("age", 25);


        String message2 = "<script>alert('ALARMA!!!!')</script>";

        request.setAttribute("message2", message2);


        getServletContext().getRequestDispatcher("/jstl.jsp").forward(request, response);
    }
}
