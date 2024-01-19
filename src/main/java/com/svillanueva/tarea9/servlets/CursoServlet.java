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

@WebServlet({"/tarea-9/", "/tarea-9/index"})
public class CursoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        CursoService cursoService = new CursoServiceImpl(conn);
        List<Curso> listaCursos = cursoService.listar();

        req.setAttribute("titulo", req.getAttribute("titulo") + " - Listado de cursos");

        req.setAttribute("listaCursos", listaCursos);
        req.getRequestDispatcher("index.jsp")
                .forward(req, resp);
    }
}
