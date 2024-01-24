package com.svillanueva.controllers;

import com.svillanueva.models.Curso;
import com.svillanueva.services.CursoService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/cursos/eliminar")
public class CursoEliminarServlet extends HttpServlet {

    @Inject
    private CursoService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        if (id > 0) {
            Optional<Curso> o = service.porId(id);
            if (o.isPresent()) {
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/cursos");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el cursos en la base de datos!");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id es null, se debe enviar como parametro en la url!");
        }
    }
}
