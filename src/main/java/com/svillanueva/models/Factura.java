package com.svillanueva.models;


import java.util.List;

//@Named
//@RequestScoped
public class Factura {
    private Cliente cliente;
    private Integer numeroFactura;
    private String descripcion;
    private List<LineaFactura> lineasFactura;

    public Factura() {
    }

    //    @PostConstruct
    public void init() {
        this.setNumeroFactura(1);
        this.setDescripcion("Factura de prueba");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    //    @Inject
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<LineaFactura> getLineasFactura() {
        return lineasFactura;
    }

    public void setLineasFactura(List<LineaFactura> lineasFactura) {
        this.lineasFactura = lineasFactura;
    }
}
