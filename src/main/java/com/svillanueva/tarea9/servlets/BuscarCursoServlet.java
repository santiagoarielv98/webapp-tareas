package com.svillanueva.tarea9.servlets;

import com.svillanueva.tarea9.models.Curso;
import com.svillanueva.tarea9.services.CursoService;
import com.svillanueva.tarea9.services.CursoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/tarea-9/buscar")
public class BuscarCursoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        String nombre = req.getParameter("nombre");

        CursoService cursoService = new CursoServiceImpl(conn);

        if (nombre != null && !nombre.isEmpty()) {
            List<Curso> listaCursos = cursoService.porNombre(nombre);
            req.setAttribute("listaCursos", listaCursos);
            req.getRequestDispatcher("index.jsp")
                    .forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/tarea-9/index");
        }
    }
}
