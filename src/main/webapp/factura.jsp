<%--@elvariable id="factura" type="com.svillanueva.models.Factura"--%>
<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 23/1/2024
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Tarea 15 - Factura</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<main class="container">
    <h1>Ejemplo Factura con inyección de dependencia 2</h1>
    <ul class="list-group">
        <li class="list-group-item">Factura: ${factura.numeroFactura}</li>
        <li class="list-group-item">Factura Oficina del cliente: ${factura.cliente.nombre}</li>
        <li class="list-group-item">${factura.cliente.nombre} ${factura.cliente.apellido}</li>
    </ul>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">Producto</th>
            <th scope="col">Precio</th>
            <th scope="col">Cantidad</th>
            <th scope="col">Total</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="f" items="${factura.lineasFactura}">
            <tr>
                <th scope="row">${f.nombreProducto}</th>
                <td>${f.precio}</td>
                <td>${f.cantidad}</td>
                <td>${f.cantidad * f.precio}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
