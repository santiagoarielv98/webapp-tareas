package com.svillanueva.resources;

import com.svillanueva.models.LineaFactura;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.Arrays;
import java.util.List;

@ApplicationScoped

public class ProducerResources {
    @Produces
    @LineasFacturaQualifier
    public List<LineaFactura> produceLineasFactura() {

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

        return Arrays.asList(lineaProducto1, lineaProducto2, lineaProducto3);
    }

}
