package org.aguzman.apiservlet.webapp.jdbc.tarea.controllers;

import jakarta.inject.Inject;
import org.aguzman.apiservlet.webapp.jdbc.tarea.services.CursoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import org.aguzman.apiservlet.webapp.jdbc.tarea.models.Curso;

@WebServlet({"/index.html", "/cursos"})
public class CursoServlet extends HttpServlet {
    
    @Inject
    private CursoService service;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Curso> cursos = service.listar();

        req.setAttribute("titulo", "Tarea: Listado de cursos");
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
