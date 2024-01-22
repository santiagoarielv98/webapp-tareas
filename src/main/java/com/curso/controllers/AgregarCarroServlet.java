package com.curso.controllers;

import com.curso.models.Carro;
import com.curso.models.ItemCarro;
import com.curso.models.Producto;
import com.curso.services.ProductoService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/curso/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {

    @Inject
    private ProductoService service;
    @Inject
    private Carro carro;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Optional<Producto> producto = service.porId(id);
        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath() + "/curso/carro/ver");
    }
}
