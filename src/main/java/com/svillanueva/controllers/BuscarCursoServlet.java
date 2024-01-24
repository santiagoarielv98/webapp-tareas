package com.svillanueva.controllers;

import com.svillanueva.models.Curso;
import com.svillanueva.services.CursoService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/cursos/buscar")
public class BuscarCursoServlet extends HttpServlet {

    @Inject
    private CursoService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");

        List<Curso> cursos = service.porNombre(nombre);

        req.setAttribute("titulo", "Tarea: filtrando cursos");
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/listar.jsp")
                .forward(req, resp);
    }
}
