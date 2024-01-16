package com.svillanueva.tarea6.servlets;

import com.svillanueva.models.Carro;
import com.svillanueva.models.ItemCarro;
import com.svillanueva.models.Producto;
import com.svillanueva.tarea3.services.ProductoService;
import com.svillanueva.tarea3.services.ProductoServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));

        ProductoService productoService = new ProductoServiceImpl();
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
