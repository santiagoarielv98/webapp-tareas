package com.curso.controllers;

import com.curso.models.Usuario;
import com.curso.services.UsuarioService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/curso/usuarios/form")
public class UsuarioFormServlet extends HttpServlet {
    @Inject
    private UsuarioService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id;
        id = ProductoFormServlet.getId(req);
        Usuario usuario = new Usuario();

        if (id > 0) {
            Optional<Usuario> o = service.porId(id);
            if (o.isPresent()) {
                usuario = o.get();
            }
        }
        req.setAttribute("usuario", usuario);
        req.setAttribute("title", req.getAttribute("title") + ": Formulario de Usuarios");

        getServletContext().getRequestDispatcher("/curso/formUsuarios.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Map<String, String> errores = new HashMap<>();

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        if (username == null || username.isBlank() || username.length() < 3 || username.length() > 12) {
            errores.put("nombre", "el nombre es requerido y debe tener entre 3 y 12 caracteres!");
        }
        if (email == null || email.isBlank() || !email.contains("@")) {
            errores.put("email", "el email es requerido!");
        }

        if (password == null || password.isBlank() || password.length() < 3 || password.length() > 12) {
            errores.put("password", "el password es requerido y debe tener entre 3 y 12 caracteres!");
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(password);


        if (errores.isEmpty()) {
            service.guardar(usuario);
            resp.sendRedirect(req.getContextPath() + "/curso/usuarios");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("usuario", usuario);
            req.setAttribute("title", req.getAttribute("title") + ": Formulario de usuarios");
            getServletContext().getRequestDispatcher("/curso/formUsuarios.jsp")
                    .forward(req, resp);
        }
    }
}
