package com.svillanueva.tarea1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/tarea-1/index.jsp")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();

        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd 'de' MMMM, yyyy");

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");

        out.println("<html>");
        out.println("<head>");
        out.println("    <title>Tarea 1 - Servlet y envío de parámetros</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("   <h3>Tarea 1: Servlet y envio de parametros</h3>");
        if (nombre != null && apellido != null) {
            out.println("   <h2>Hola mi nombre es: " + nombre + " " + apellido + "</h2>");
        } else {
            out.println("   <h2>No existen los datos enviados</h2>");
        }
        out.println("   <h3>La fecha actual es: " + now.format(dateTimeFormatter) + "</h3>");

        out.println("</body>");
        out.println("</html>");
    }
}
