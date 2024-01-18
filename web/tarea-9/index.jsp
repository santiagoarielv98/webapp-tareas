<%@ page import="com.svillanueva.tarea9.models.Curso" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/1/2024
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    @SuppressWarnings("unchecked")
    List<Curso> listaCursos = (List<Curso>) request.getAttribute("listaCursos");
%>
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
        <% for (Curso curso : listaCursos) { %>
    <tr>
        <td><%= curso.getId() %>
        </td>
        <td><%= curso.getNombre() %>
        </td>
        <td><%= curso.getDescripcion() %>
        </td>
        <td><%= curso.getInstructor() %>
        </td>
        <td><%= curso.getDuracion() %>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/tarea-9/crear<%= "?id=" + curso.getId()%>">Editar</a>
        </td>
        <td>
            <a onclick="return confirm('Desear elminar el Curso?');" href="${pageContext.request.contextPath}/tarea-9/eliminar<%= "?id=" + curso.getId()%>">Eliminar</a>
        </td>
    </tr>
        <% } %>
</body>
</html>
