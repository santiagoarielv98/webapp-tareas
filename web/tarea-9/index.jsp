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
<form action="${pageContext.request.contextPath}/tarea-9/buscar">
    <label for="nombre">
        <input type="text" name="nombre" id="nombre">
        <input type="submit" value="Buscar">
    </label>
</form>
<table>
    <tr>
        <td>id</td>
        <td>nombre</td>
        <td>instructor</td>
        <td>duracion</td>
    </tr>
        <% for (Curso curso : listaCursos) { %>
    <tr>
        <td><%= curso.getId() %>
        </td>
        <td><%= curso.getNombre() %>
        </td>
        <td><%= curso.getInstructor() %>
        </td>
        <td><%= curso.getDuracion() %>
        </td>
    </tr>
        <% } %>
</body>
</html>
