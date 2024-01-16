package com.svillanueva.tarea6.services;

import com.svillanueva.models.Carro;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImpl implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return Optional.ofNullable((String) session.getAttribute("username"));
    }

    @Override
    public Optional<Carro> getCarro(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return Optional.ofNullable((Carro) session.getAttribute("carro"));
    }
}
