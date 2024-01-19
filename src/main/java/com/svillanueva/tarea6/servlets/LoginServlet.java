package com.svillanueva.tarea6.servlets;

import com.svillanueva.models.Usuario;
import com.svillanueva.services.UsuarioService;
import com.svillanueva.services.UsuarioServiceImpl;
import com.svillanueva.tarea6.services.LoginService;
import com.svillanueva.tarea6.services.LoginServiceSessionImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet({"/tarea-6/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService authService = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = authService.getUsername(req);

        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("   <meta charset=\"UTF-8\">");
                out.println("   <title>Hola " + usernameOptional.get() + "</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("   <h1>Hola " + usernameOptional.get() + " has iniciado sesión con éxito!</h1>");
                out.println("   <a href=\"index.jsp\">volver</a>");
                out.println("   <a href=\"logout.jsp\">cerrar sesión</a>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            req.getRequestDispatcher("login.jsp")
                    .forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Connection conn = (Connection) req.getServletContext()
                .getAttribute("conn");

        UsuarioService usuarioService = new UsuarioServiceImpl(conn);
        Optional<Usuario> usuarioOptional;
        try {
            usuarioOptional = usuarioService.login(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (usuarioOptional.isPresent()) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            resp.sendRedirect("login");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
        }
    }
}

