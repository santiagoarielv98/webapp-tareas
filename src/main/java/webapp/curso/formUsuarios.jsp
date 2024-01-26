<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>

<h3>${requestScope.title}</h3>
<form action="${pageContext.request.contextPath}/curso/usuarios/form" method="post">
    <div class="row mb-2">
        <label for="username" class="col-form-label col-sm-2">Username</label>
        <div class="col-sm-4">
            <input type="text" name="username" id="username" value="${requestScope.usuario.username}"
                   class="form-control">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('username')}">
            <div style="color:red;">${requestScope.errores.username}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="email" class="col-form-label col-sm-2">Email</label>
        <div class="col-sm-4">
            <input type="text" name="email" id="email" value="${requestScope.usuario.email}" class="form-control">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('email')}">
            <div style="color:red;">${requestScope.errores.email}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="password" class="col-form-label col-sm-2">Password</label>
        <div class="col-sm-4">
            <input type="password" name="password" id="password" value="${requestScope.usuario.password}"
                   class="form-control">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('password')}">
            <div style="color:red;">${requestScope.errores.password}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <div>
            <input class="btn btn-primary" type="submit"
                   value="${requestScope.usuario.id!=null && requestScope.usuario.id>0 ? "Editar": "Crear"}">
        </div>
    </div>
    <input type="hidden" name="id" value="${requestScope.usuario.id}">
</form>

<jsp:include page="layout/footer.jsp"/>
