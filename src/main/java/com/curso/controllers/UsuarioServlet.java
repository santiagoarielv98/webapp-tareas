package com.curso.controllers;

import com.curso.models.Usuario;
import com.curso.services.LoginService;
import com.curso.services.LoginServiceSessionImpl;
import com.curso.services.UsuarioService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet({"/curso/usuarios.html", "/curso/usuarios"})
public class UsuarioServlet extends HttpServlet {
    @Inject
    private UsuarioService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        req.setAttribute("usuarios", usuarios);
        req.setAttribute("username", usernameOptional);
        req.setAttribute("title", req.getAttribute("title") + ": Listado de usuarios");
        getServletContext().getRequestDispatcher("/curso/listarUsuarios.jsp")
                .forward(req, resp);
    }
}
