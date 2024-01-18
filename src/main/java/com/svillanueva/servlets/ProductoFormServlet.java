package com.svillanueva.servlets;

import com.svillanueva.models.Categoria;
import com.svillanueva.models.Producto;
import com.svillanueva.services.ProductServiceJdbcImpl;
import com.svillanueva.tarea3.services.ProductoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/producto/form")
public class ProductoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");


        ProductoService productoService = new ProductServiceJdbcImpl(conn);

        long id;
        Optional<Producto> producto = Optional.empty();

        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }

        if (id > 0L) {
            producto = productoService.porId(id);
        }


        req.setAttribute("listaCategorias", productoService.listarCategorias());
        req.setAttribute("producto", producto);

        req.getRequestDispatcher("/form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ProductoService productService = new ProductServiceJdbcImpl(conn);


        Producto p = new Producto();
        Categoria c = new Categoria();


        long id;

        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }

        if (id > 0) {
            p.setId(id);
        }


        String nombre = req.getParameter("nombre");
        int precio;
        try {
            precio = Integer.parseInt(req.getParameter("precio"));
        } catch (NumberFormatException e) {
            precio = 0;
        }
        String sku = req.getParameter("sku");
        LocalDate fechaRegistro;
        try {
            fechaRegistro = LocalDate.parse(req.getParameter("fechaRegistro"));
        } catch (Exception e) {
            fechaRegistro = LocalDate.now();
        }
        long categoriaId;
        try {
            categoriaId = Long.parseLong(req.getParameter("categoria"));
        } catch (NumberFormatException e) {
            categoriaId = 0L;
        }


        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setSku(sku);
        p.setFechaRegistro(fechaRegistro);
        c.setId(categoriaId);
        p.setCategoria(c);

        Map<String, String> errores = new HashMap<>();

        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "El nombre es requerido");
        }
        if (sku == null || sku.isBlank()) {
            errores.put("sku", "El sku es requerido");
        }
        if (precio == 0) {
            errores.put("precio", "El precio es requerido");
        }
        if (categoriaId == 0) {
            errores.put("categoria", "La categoria es requerida");
        }

        if (errores.isEmpty()) {
            productService.guardar(p);
            resp.sendRedirect(req.getContextPath() + "/tarea-6/productos");
        } else {
            req.setAttribute("errores", errores);
            doGet(req, resp);
        }
    }
}
