package com.svillanueva.tarea3;

import com.svillanueva.models.Producto;
import com.svillanueva.tarea3.services.ProductoService;
import com.svillanueva.tarea3.services.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/tarea-3/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ProductoService service = new ProductoServiceImpl();
        String nombre = req.getParameter("producto");

        Optional<Producto> encontrado = service.buscarProducto(nombre);

        if (encontrado.isPresent()) {
            Producto producto = encontrado.get();
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <title>Producto encontrado</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Producto encontrado!</h1>");
                out.println("        <h3>Producto encontrado: " +
                        producto.getId() + ". " +
                        producto
                                .getNombre() +
                        " el precio $" + producto
                        .getPrecio() + " de la categoría " + producto
                        .getCategoria() + "</h3>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Lo sentimos no se encontró el producto '" + nombre + "'");
        }
    }
}