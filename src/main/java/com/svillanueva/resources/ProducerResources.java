package com.svillanueva.resources;

import com.svillanueva.models.LineaFactura;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.ArrayList;
import java.util.List;

//@ApplicationScoped
public class ProducerResources {
//    @Produces
    public List<LineaFactura> produceLineasFactura() {
        List<LineaFactura> lineaFacturas = new ArrayList<>();

        LineaFactura lineaProducto1 = new LineaFactura();
        LineaFactura lineaProducto2 = new LineaFactura();
        LineaFactura lineaProducto3 = new LineaFactura();
        lineaProducto1.setNombreProducto("Producto 1");
        lineaProducto1.setCantidad(99);
        lineaProducto1.setPrecio(10);

        lineaProducto2.setNombreProducto("Producto 2");
        lineaProducto2.setCantidad(99);
        lineaProducto2.setPrecio(5);

        lineaProducto3.setNombreProducto("Producto 3");
        lineaProducto3.setCantidad(99);
        lineaProducto3.setPrecio(2);

        lineaFacturas.add(lineaProducto1);
        lineaFacturas.add(lineaProducto2);
        lineaFacturas.add(lineaProducto3);

        return lineaFacturas;
    }

}
