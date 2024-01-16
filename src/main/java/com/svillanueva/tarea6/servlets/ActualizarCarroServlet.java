package com.svillanueva.tarea6.servlets;

import com.svillanueva.models.Carro;
import com.svillanueva.tarea6.services.LoginService;
import com.svillanueva.tarea6.services.LoginServiceSessionImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/tarea-6/actualizar-carro")
public class ActualizarCarroServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginService authService = new LoginServiceSessionImpl();

        Optional<Carro> carro = authService.getCarro(req);

        String[] idProductos = req.getParameterValues("idProducto");
        String[] cantidades = req.getParameterValues("cantidad");
        String[] borrarProductos = req.getParameterValues("borrarProducto");

        for (int i = 0; i < idProductos.length; i++) {
            String idProducto = idProductos[i];
            String cantidad = cantidades[i];
            carro.ifPresent(c -> c.updateItemCarro(idProducto, cantidad));
        }

        if (borrarProductos != null) {
            for (String idProducto : borrarProductos) {
                carro.ifPresent(c -> c.removeItemCarro(idProducto));
            }
        }

        resp.sendRedirect("ver-carro");
    }
}
