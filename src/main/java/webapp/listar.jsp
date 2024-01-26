<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/1/2024
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>¡Listado de Productos!</h1>

<div>Hola, Santiago bienvenido</div>
<a href="${pageContext.request.contextPath}/producto/form">Crear [+] </a>
<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>tipo</th>
        <th>precio</th>
        <th>agregar</th>
        <th>editar</th>
        <th>eliminar</th>
    </tr>
    <c:forEach items="${requestScope.listaProducto}" var="p">
        <tr>
            <td>
                    ${p.id}
            </td>
            <td>
                    ${p.nombre}
            </td>
            <td>
                    ${p.categoria.nombre}
            </td>
            <td>
                    ${p.precio}
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/tarea-6/agregar-carro${"?id="}${p.getId()}">
                    agregar al carro
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/producto/form${"?id="}${p.getId()}">editar</a>
            <td>
                <a onclick="return confirm('Deseas Eliminar este producto');"
                   href="${pageContext.request.contextPath}/producto/eliminar${"?id="}${p.getId()}">eliminar</a>
        </tr>
    </c:forEach>
</table>
</body>
</html>
