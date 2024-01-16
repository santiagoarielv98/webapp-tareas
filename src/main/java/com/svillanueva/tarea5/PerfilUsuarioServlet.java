package com.svillanueva.tarea5;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tarea-5/perfil-usuario")
public class PerfilUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter out = resp.getWriter()) {

            String nombre = "anónimo";
            HttpSession session = req.getSession();

            String nombreSession = (String) session.getAttribute("nombre");

            if (nombreSession != null && !nombreSession.isBlank()) {
                nombre = nombreSession;
            }

            out.println("<html>");
            out.println("<head>");
            out.println("   <meta charset=\"UTF-8\">");
            out.println("   <title>Perfil del usuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Perfil del usuario " + nombre + "!</h1>");
            out.println("   <ul>");
            out.println("       <li>Username: " + nombre + "</li>");
            out.println("   </ul>");
            out.println("<p><a href=\"index.jsp\">volver al index</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
