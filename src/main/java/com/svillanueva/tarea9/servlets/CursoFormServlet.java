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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/tarea-9/crear")
public class CursoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService cursoService = new CursoServiceImpl(conn);

        Curso c = new Curso();
        c.setId(0L);
        c.setNombre("");
        c.setInstructor("");
        c.setDuracion(0D);
        c.setDescripcion("");

        long id;

        try {
            id = Long.parseLong(req.getParameter("id"));
            Optional<Curso> curso = cursoService.porId(id);
            if (curso.isPresent()) {
                Curso encontrado = curso.get();
                c.setId(encontrado.getId());
                c.setNombre(encontrado.getNombre());
                c.setInstructor(encontrado.getInstructor());
                c.setDuracion(encontrado.getDuracion());
                c.setDescripcion(encontrado.getDescripcion());
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Curso no encontrado");
            }
        } catch (NumberFormatException e) {
            id = 0L;
        }
        req.setAttribute("titulo", req.getAttribute("titulo") + (id == 0L ? " - Crear curso" : " - Editar curso"));
        req.setAttribute("curso", c);
        req.setAttribute("id", id);
        req.getRequestDispatcher("form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService cursoService = new CursoServiceImpl(conn);
        Map<String, String> errores = new HashMap<>();

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        String nombre = req.getParameter("nombre");
        String instructor = req.getParameter("instructor");
        double duracion;
        try {
            duracion = Double.parseDouble(req.getParameter("duracion"));
        } catch (NumberFormatException e) {
            duracion = 0D;
        }

        String descripcion = req.getParameter("descripcion");


        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "el nombre es requerido");
        }
        if (instructor == null || instructor.isBlank()) {
            errores.put("instructor", "el nombre del instructor es requerido");
        }
        if (duracion <= 0D) {
            errores.put("duracion", "la duracion debe ser mayor a 0");
        }
        if (descripcion == null || descripcion.isBlank()) {
            errores.put("descripcion", "la descripcion es requerida");
        }

        Curso c = new Curso();
        c.setId(id);
        c.setNombre(nombre);
        c.setInstructor(instructor);
        c.setDuracion(duracion);
        c.setDescripcion(descripcion);

        req.setAttribute("titulo", req.getAttribute("titulo") + (id == 0L ? " - Crear curso" : " - Editar curso"));

        if (errores.isEmpty()) {
            cursoService.guardar(c);
            resp.sendRedirect(req.getContextPath() + "/tarea-9/index");
        } else {
            req.setAttribute("curso", c);
            req.setAttribute("errores", errores);
            req.getRequestDispatcher("/tarea-9/form.jsp")
                    .forward(req, resp);
        }

    }
}
