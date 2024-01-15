package com.svillanueva.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/cambiar-color")
public class CambiarColorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie color = new Cookie("color", req.getParameter("color"));
        resp.addCookie(color);
        resp.sendRedirect("index.jsp");
    }
}
