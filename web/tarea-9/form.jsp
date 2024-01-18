<%@ page import="java.util.Map" %>
<%@ page import="com.svillanueva.tarea9.models.Curso" %>
<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/1/2024
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%

    Curso curso = (Curso) request.getAttribute("curso");

    @SuppressWarnings("unchecked")
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");

    String titulo = "Crear";
%>

<html>
<head>
    <title>Tarea 10- <%=titulo%> curso</title>
</head>
<body>
<h1>Tarea 10: <%=titulo%> curso</h1>
<a href="${pageContext.request.contextPath}/tarea-9/index">volver</a>
<form action="${pageContext.request.contextPath}/tarea-9/crear" method="post">
    <input type="hidden" name="id" value="<%=curso.getId()%>">
    <div>
        <label for="nombre">Nombre</label>
        <div>
            <input type="text" name="nombre" id="nombre" value="<%=curso.getNombre()%>">
        </div>
        <% if (errores != null && errores.containsKey("nombre")) { %>
        <span style="color:red;"><%=errores.get("nombre")%></span>
        <% } %>
    </div>
    <div>
        <label for="instructor">Instructor</label>
        <div>
            <input type="text" name="instructor" id="instructor" value="<%=curso.getInstructor()%>">
        </div>
        <% if (errores != null && errores.containsKey("instructor")) { %>
        <span style="color:red;"><%=errores.get("instructor")%></span>
        <% } %>
    </div>
    <div>
        <label for="duracion">Duracion</label>
        <div>
            <input type="text" name="duracion" id="duracion" value="<%=curso.getDuracion()%>">
        </div>
        <% if (errores != null && errores.containsKey("duracion")) { %>
        <span style="color:red;"><%=errores.get("duracion")%></span>
        <% } %>
    </div>
    <div>
        <label for="descripcion">Descripcion</label>
        <div>
            <textarea name="descripcion" id="descripcion"><%=curso.getDescripcion()%></textarea>
        </div>
        <% if (errores != null && errores.containsKey("descripcion")) { %>
        <span style="color:red;"><%=errores.get("descripcion")%></span>
        <% } %>
    </div>
    <input type="submit" value="<%=titulo%>">
</form>
</body>
</html>
