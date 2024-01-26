<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 16/1/2024
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.Map" %>

<%
    String nombre = (String) request.getAttribute("nombre");
    String precio = (String) request.getAttribute("precio");
    String fabricante = (String) request.getAttribute("fabricante");

    String mensaje = (String) request.getAttribute("mensaje");

    @SuppressWarnings("unchecked")
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");

    String nombreError = null;
    String precioError = null;
    String fabricanteError = null;

    boolean hayErrores = errores != null && !errores.isEmpty();

    if (hayErrores) {
        nombreError = errores.get("nombre");
        precioError = errores.get("precio");
        fabricanteError = errores.get("fabricante");
    }
%>

<!doctype html>
<html lang="en">
<head>
    <title>Tarea 2 - Formulario de productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        html, body {
            height: 100%;
        }
    </style>
</head>
<body class="d-flex align-items-center justify-content-center container">
<main class="m-auto">
    <div class="card" style="width: 300px;">
        <div class="card-header">
            <h4 class="card-title">Registrar Producto</h4>
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/tarea-2/crear"
                  class="needs-validation<%= hayErrores ? " was-validated" : "" %>" method="post"
                  novalidate>
                <div class="mb-3">
                    <label for="inputNombre" class="form-label">Nombre del producto</label>
                    <input type="text" class="form-control" id="inputNombre" name="nombre"
                           value="<%= nombre != null ? nombre : "" %>"
                           placeholder="Nombre del Producto" required aria-describedby="nombreError">
                    <span id="nombreError" class="invalid-feedback"><%= nombreError != null ? nombreError : "" %></span>
                </div>
                <div class="mb-3">
                    <label for="inputPrecio" class="form-label">Precio</label>
                    <input type="number" class="form-control" id="inputPrecio" name="precio"
                           value="<%= precio != null ? precio : ""%>"
                           placeholder="Precio"
                           required step="1" aria-describedby="precioError">
                    <span id="precioError" class="invalid-feedback"><%= precioError != null ? precioError : ""%></span>
                </div>
                <div class="mb-3">
                    <label for="inputFabricante" class="form-label">Fabricante</label>
                    <input type="text" class="form-control" id="inputFabricante" name="fabricante"
                           value="<%= fabricante != null ? fabricante : ""%>"
                           placeholder="Fabricante" required minlength="4" maxlength="10"
                           aria-describedby="fabricanteError">
                    <span id="fabricanteError"
                          class="invalid-feedback"><%= fabricanteError != null ? fabricanteError : ""%></span>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</main>
<% if (mensaje != null) { %>
<div class="alert alert-success alert-dismissible fade show position-fixed bottom-0 end-0 m-3" role="alert">
    <strong><%= mensaje %>
    </strong>
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<% } %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>