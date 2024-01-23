package com.svillanueva.servlets;


import com.svillanueva.models.Cliente;
import com.svillanueva.models.Factura;
import com.svillanueva.models.LineaFactura;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/factura")
public class FacturaController extends HttpServlet {

//    @Inject
//    private Factura factura;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LineaFactura> lineaFacturas = new ArrayList<>();
        LineaFactura lineaFactura = new LineaFactura();
        lineaFactura.setNombreProducto("Producto 1");
        lineaFactura.setPrecio(5);
        lineaFactura.setCantidad(99);

        LineaFactura lineaFactura2 = new LineaFactura();
        lineaFactura.setNombreProducto("Producto 2");
        lineaFactura.setPrecio(7);
        lineaFactura.setCantidad(99);

        lineaFacturas.add(lineaFactura);
        lineaFacturas.add(lineaFactura2);

        Factura factura = new Factura();
        Cliente cliente = new Cliente();
        cliente.setApellido("Villanueva");
        cliente.setNombre("Santiago");
        cliente.setEmail("santiago@villanueva.com");
        factura.setCliente(cliente);
        factura.setLineasFactura(lineaFacturas);

        req.setAttribute("factura", factura);

        req.getRequestDispatcher("factura.jsp")
                .forward(req, resp);

    }
}
