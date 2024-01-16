package com.svillanueva.tarea2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/tarea-2/crear")
public class RegistroProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getContextPath());
        req.getRequestDispatcher("form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String nombre = req.getParameter("nombre");
        String precio = req.getParameter("precio");
        String fabricante = req.getParameter("fabricante");
        Map<String, String> errores = new HashMap<>();

        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "El nombre no puede estar vació");
        }

        if (precio == null || precio.isBlank()) {
            errores.put("precio", "El precio no puede estar vació");
        } else {
            try {
                Double.parseDouble(precio);
            } catch (NumberFormatException e) {
                errores.put("precio", "El precio debe ser un número");
            }
        }

        if (fabricante == null || fabricante.isBlank()) {
            errores.put("fabricante", "El fabricante no puede estar vació");
        } else if (fabricante.length() < 4 || fabricante.length() > 10) {
            errores.put("fabricante", "El fabricante debe tener entre 4 y 10 caracteres");
        }

        req.setAttribute("nombre", nombre);
        req.setAttribute("precio", precio);
        req.setAttribute("fabricante", fabricante);

        req.setAttribute("errores", errores);

        if (errores.isEmpty()) {
            req.setAttribute("mensaje", "El producto '" + nombre + "' ha sido registrado con éxito");
        }

        req.getRequestDispatcher("form.jsp")
                .forward(req, resp);
    }
}