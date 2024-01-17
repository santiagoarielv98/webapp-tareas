package com.svillanueva.tarea7;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletRequest()
                .setAttribute("nombreCompleto", "Santiago Villanueva");
    }
}
