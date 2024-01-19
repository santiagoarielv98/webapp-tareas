<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/1/2024
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Tarea 9 - Listado de cursos</title>
</head>
<body>
<h1>Tarea 9: Listado de cursos</h1>
<a href="${pageContext.request.contextPath}/tarea-9/crear">Crear [+]</a>
<form action="${pageContext.request.contextPath}/tarea-9/buscar" method="post">
    <label for="nombre">
        <input type="text" name="nombre" id="nombre">
        <input type="submit" value="Buscar">
    </label>
</form>
<table>
    <tr>
        <td>id</td>
        <td>nombre</td>
        <td>descripcion</td>
        <td>instructor</td>
        <td>duracion</td>
        <td>editar</td>
        <td>eliminar</td>
    </tr>
    <c:forEach items="${requestScope.listaCursos}" var="curso">
    <tr>
        <td>
                ${curso.id}
        </td>
        <td>
                ${curso.nombre}
        </td>
        <td>
                ${curso.descripcion}
        </td>
        <td>
                ${curso.instructor}
        </td>
        <td>
                ${curso.duracion}
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/tarea-9/crear${"?id="}${curso.id}">Editar</a>
        </td>
        <td>
            <a onclick="return confirm('Desear eliminar el Curso?');"
               href="${pageContext.request.contextPath}/tarea-9/eliminar${"?id="}${curso.id}">Eliminar</a>
        </td>
    </tr>
    </c:forEach>
</body>
</html>
