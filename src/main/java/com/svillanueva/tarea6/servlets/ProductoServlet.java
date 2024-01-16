package com.svillanueva.tarea6.servlets;

import com.svillanueva.models.Producto;
import com.svillanueva.tarea3.services.ProductoService;
import com.svillanueva.tarea3.services.ProductoServiceImpl;
import com.svillanueva.tarea6.services.LoginService;
import com.svillanueva.tarea6.services.LoginServiceSessionImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/tarea-6/productos.html", "/tarea-6/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProductoService productService = new ProductoServiceImpl();
        List<Producto> listaProducto = productService.listar();

        LoginService authService = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = authService.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("   <meta charset=\"UTF-8\">");
            out.println("   <title>Listado de Productos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Listado de Productos!</h1>");
            usernameOptional.ifPresent(nombre -> out.println("<p style='color: blue;'>Hola " + nombre + " Bienvenido!</p>"));
            out.println("   <table>");
            out.println("       <tr>");
            out.println("           <th>id</th>");
            out.println("           <th>nombre</th>");
            out.println("           <th>tipo</th>");
            if (usernameOptional.isPresent()) {
                out.println("           <th>precio</th>");
                out.println("           <th>agregar</th>");
            }
            out.println("       </tr>");
            listaProducto.forEach(p -> {
                out.println("       <tr>");
                out.println("           <td>" + p.getId() + "</td>");
                out.println("           <td>" + p.getNombre() + "</td>");
                out.println("           <td>" + p.getTipo() + "</td>");
                if (usernameOptional.isPresent()) {
                    out.println("           <td>" + p.getPrecio() + "</td>");
                    out.println("           <td><a href=\"agregar-carro?id=" + p.getId()
                            + "\">agregar al carro</a></td>");
                }
                out.println("       </tr>");
            });
            out.println("   </table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
