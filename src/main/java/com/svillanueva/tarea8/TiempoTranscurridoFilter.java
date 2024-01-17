package com.svillanueva.tarea8;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class TiempoTranscurridoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long tiempoInicio = System.currentTimeMillis();
        chain.doFilter(request, response);
        long tiempoFinal = System.currentTimeMillis();
        long tiempoTranscurrido = tiempoFinal - tiempoInicio;

        System.out.println("El tiempo de carga de la página es de " + tiempoTranscurrido + " milisegundos");

    }


}
