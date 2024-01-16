package com.svillanueva.tarea6.servlets;

import com.svillanueva.tarea6.services.LoginService;
import com.svillanueva.tarea6.services.LoginServiceSessionImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet({"/tarea-6/logout", "/tarea-6/logout.jsp"})
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        LoginService authService = new LoginServiceSessionImpl();
        Optional<String> username = authService.getUsername(req);
        if (username.isPresent()) {
            HttpSession session = req.getSession();
            session.invalidate();
        }
        resp.sendRedirect("login.jsp");
    }
}

