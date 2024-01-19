<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/1/2024
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="titulo" value="${requestScope.curso.id != null || requestScope.curso.id == 0 ? 'Editar' : 'Crear'}"/>

<html>
<head>
    <title>Tarea 10- ${titulo} curso</title>
</head>
<body>
<h1>Tarea 10: ${titulo} curso</h1>
<a href="${pageContext.request.contextPath}/tarea-9/index">volver</a>
<form action="${pageContext.request.contextPath}/tarea-9/crear" method="post">
    <input type="hidden" name="id" value="${requestScope.curso.id}">
    <div>
        <label for="nombre">Nombre</label>
        <div>
            <input type="text" name="nombre" id="nombre" value="${requestScope.curso.nombre}">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('nombre')}">
            <span style="color:red;">${requestScope.errores.get('nombre')}</span>
        </c:if>
    </div>
    <div>
        <label for="instructor">Instructor</label>
        <div>
            <input type="text" name="instructor" id="instructor" value="${requestScope.curso.instructor}">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('instructor')}">
            <span style="color:red;">${requestScope.errores.get('instructor')}</span>
        </c:if>
    </div>
    <div>
        <label for="duracion">Duracion</label>
        <div>
            <input type="text" name="duracion" id="duracion" value="${requestScope.curso.duracion}">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('duracion')}">
            <span style="color:red;">${requestScope.errores.get('duracion')}</span>
        </c:if>
    </div>
    <div>
        <label for="descripcion">Descripcion</label>
        <div>
            <textarea name="descripcion" id="descripcion">${requestScope.curso.descripcion}</textarea>
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('descripcion')}">
            <span style="color:red;">${requestScope.errores.get('descripcion')}</span>
        </c:if>
    </div>
    <input type="submit" value="${titulo}">
</form>
</body>
</html>
