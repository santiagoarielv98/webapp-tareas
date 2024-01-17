package com.svillanueva.tarea7;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/tarea-6/index.html", ""})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombreCompleto = (String) req
                .getAttribute("nombreCompleto");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <title>Tarea 7 - Listener</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Tarea 7 Listener!</h1>");
            out.println("   <p>Mi nombre es " + nombreCompleto + "</p>");
            out.println("</body>");
            out.println("</html>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
