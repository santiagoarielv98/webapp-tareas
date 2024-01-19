<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/1/2024
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="tituloAccion" value="${requestScope.curso.id == null || requestScope.curso.id == 0 ? 'Crear' : 'Editar'}"/>
<jsp:include page="/layout/header.jsp"/>
<h1>Tarea 10: ${tituloAccion} curso</h1>
<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/tarea-9/index">volver</a>

<form class="needs-validation" action="${pageContext.request.contextPath}/tarea-9/crear" method="post"
      style="max-width: 500px" novalidate>
    <input type="hidden" name="id" value="${requestScope.curso.id}">
    <div class="mb-3">
        <label class="form-label" for="nombre">Nombre</label>
        <div>
            <input required class="form-control" type="text" name="nombre" id="nombre" value="${requestScope.curso.nombre}">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('nombre')}">
            <span class="invalid-feedback d-block">${requestScope.errores.get('nombre')}</span>
        </c:if>
    </div>
    <div class="mb-3">
        <label class="form-label" for="instructor">Instructor</label>
        <div>
            <input required class="form-control" type="text" name="instructor" id="instructor"
                   value="${requestScope.curso.instructor}">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('instructor')}">
            <span class="invalid-feedback d-block">${requestScope.errores.get('instructor')}</span>
        </c:if>
    </div>
    <div class="mb-3">
        <label class="form-label" for="duracion">Duracion</label>
        <div>
            <input required class="form-control" type="text" name="duracion" id="duracion"
                   value="${requestScope.curso.duracion}">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('duracion')}">
            <span class="invalid-feedback d-block">${requestScope.errores.get('duracion')}</span>
        </c:if>
    </div>
    <div class="mb-3">
        <label class="form-label" for="descripcion">Descripcion</label>
        <div>
            <textarea class="form-control" name="descripcion"
                      id="descripcion">${requestScope.curso.descripcion}</textarea>
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('descripcion')}">
            <span class="invalid-feedback d-block">${requestScope.errores.get('descripcion')}</span>
        </c:if>
    </div>
    <button type="submit" class="btn btn-primary">${tituloAccion}</button>
</form>
<jsp:include page="/layout/footer.jsp"/>