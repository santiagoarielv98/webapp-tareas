package com.svillanueva.servlets;

import com.svillanueva.services.ProductServiceJdbcImpl;
import com.svillanueva.tarea3.services.ProductoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/producto/eliminar")
public class ProductoEliminarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ProductoService productoService = new ProductServiceJdbcImpl(conn);


        long id;

        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }

        if (id > 0) {
            productoService.eliminar(id);
        }

        resp.sendRedirect(req.getContextPath() + "/tarea-6/productos");
    }
}
