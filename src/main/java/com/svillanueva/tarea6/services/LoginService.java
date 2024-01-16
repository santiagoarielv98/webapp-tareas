package com.svillanueva.tarea6.services;

import com.svillanueva.models.Carro;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {
    Optional<String> getUsername(HttpServletRequest request);

    Optional<Carro> getCarro(HttpServletRequest request);
}
