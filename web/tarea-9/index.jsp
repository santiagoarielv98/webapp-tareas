<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/1/2024
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/layout/header.jsp"/>
<h1>Tarea 9: Listado de cursos</h1>
<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/tarea-9/crear">Crear [+]</a>
<form action="${pageContext.request.contextPath}/tarea-9/buscar" method="post">
    <label for="nombre" class="input-group my-3">
        <input type="text" name="nombre" id="nombre" class="form-control" style="max-width: 300px">
        <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Buscar</button>
    </label>
</form>
<table class="table table-striped table-hover">
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
                <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/tarea-9/crear${"?id="}${curso.id}">Editar</a>
            </td>
            <td>
                <a class="btn btn-danger btn-sm" onclick="return confirm('Desear eliminar el Curso?');"
                   href="${pageContext.request.contextPath}/tarea-9/eliminar${"?id="}${curso.id}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="/layout/footer.jsp"/>
