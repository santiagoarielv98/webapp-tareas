<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>
<h3>${requestScope.title}</h3>
<c:if test="${requestScope.username.present}">
    <div class="alert alert-info">Hola ${requestScope.username.get()}, bienvenido!</div>
    <a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/curso/usuarios/form">crear [+]</a>
</c:if>
<table class="table table-hover table-striped">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>email</th>
        <c:if test="${requestScope.username.present}">
            <th>agregar</th>
            <th>editar</th>
        </c:if>
    </tr>
    <c:forEach items="${requestScope.usuarios}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.username}</td>
            <td>${p.email}</td>
            <c:if test="${requestScope.username.present}">
                <td><a class="btn btn-sm btn-success"
                       href="${pageContext.request.contextPath}/curso/usuarios/form${"?id="}${p.id}">editar</a></td>
                <td><a class="btn btn-sm btn-danger" onclick="return confirm('esta seguro que desea eliminar?');"
                       href="${pageContext.request.contextPath}/curso/usuarios/eliminar${"?id="}${p.id}">eliminar</a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<jsp:include page="layout/footer.jsp"/>
