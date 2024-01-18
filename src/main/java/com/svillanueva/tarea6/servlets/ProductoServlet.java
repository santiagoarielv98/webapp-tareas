package com.svillanueva.tarea6.servlets;

import com.svillanueva.models.Producto;
import com.svillanueva.services.ProductServiceJdbcImpl;
import com.svillanueva.tarea3.services.ProductoService;
import com.svillanueva.tarea6.services.LoginService;
import com.svillanueva.tarea6.services.LoginServiceSessionImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet("/tarea-6/productos")
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Connection conn = (Connection) req.getAttribute("conn");
        ProductoService productService = new ProductServiceJdbcImpl(conn);
        List<Producto> listaProducto = productService.listar();

        LoginService authService = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = authService.getUsername(req);

        req.setAttribute("listaProducto", listaProducto);
        req.setAttribute("username", usernameOptional);
        req.getRequestDispatcher("/listar.jsp")
                .forward(req, resp);

    }

}
