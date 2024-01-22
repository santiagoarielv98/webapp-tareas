package com.curso.controllers;

import com.curso.models.Producto;
import com.curso.services.LoginService;
import com.curso.services.LoginServiceSessionImpl;
import com.curso.services.ProductoService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet({"/curso/productos.html", "/curso/productos"})
public class ProductoServlet extends HttpServlet {

    @Inject
    private ProductoService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ProductoService service = new ProductoServiceJdbcImpl(conn);
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        req.setAttribute("productos", productos);
        req.setAttribute("username", usernameOptional);
        req.setAttribute("title", req.getAttribute("title") + ": Listado de productos");
        getServletContext().getRequestDispatcher("/curso/listar.jsp")
                .forward(req, resp);
    }
}
