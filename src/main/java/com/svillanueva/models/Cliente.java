package com.svillanueva.models;


//@RequestScoped
public class Cliente {
    private String nombre;
    private String email;
    private String apellido;

    public Cliente() {
    }

    //    @PostConstruct
    public void init() {
        this.setNombre("Santiago");
        this.setEmail("santiago@udemy.com");
        this.setApellido("Villanueva");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
