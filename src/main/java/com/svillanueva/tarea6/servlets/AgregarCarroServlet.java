package com.svillanueva.tarea6.servlets;

import com.svillanueva.models.Carro;
import com.svillanueva.models.ItemCarro;
import com.svillanueva.models.Producto;
import com.svillanueva.services.ProductServiceJdbcImpl;
import com.svillanueva.tarea3.services.ProductoService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/tarea-6/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        Long id = Long.parseLong(req.getParameter("id"));

        ProductoService productoService = new ProductServiceJdbcImpl(conn);
        Optional<Producto> producto = productoService.porId(id);

        producto.ifPresent(p -> {
            ItemCarro item = new ItemCarro(1, p);
            HttpSession session = req.getSession();
            Carro carro = (Carro) session.getAttribute("carro");

            if (carro == null) {
                carro = new Carro();
                session.setAttribute("carro", carro);
            }

            carro.addItemCarro(item);
        });
        resp.sendRedirect("ver-carro");
    }
}
