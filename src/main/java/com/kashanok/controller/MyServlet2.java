package com.kashanok.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.kashanok.controller.MyServlet.COOKIE;


@WebServlet(urlPatterns = "/test_ser")
public class MyServlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = "Vasya";

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if(c.getName().equalsIgnoreCase(COOKIE)) {
                name = "COOKIE NAME";
            }
        }

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("name", name + "SERV CONT");
        servletContext.setAttribute("age", 35);

        servletContext.getRequestDispatcher("/test.jsp").forward(request, response);
    }
}
