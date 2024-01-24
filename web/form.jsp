<%@ page import="java.time.format.DateTimeFormatter" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>

<h3>${requestScope.title}</h3>

<form action="${pageContext.request.contextPath}/curso/productos/form" method="post">
    <div class="row mb-2">
        <label for="nombre" class="col-form-label col-sm-2">Nombre</label>
        <div class="col-sm-4">
            <input type="text" name="nombre" id="nombre" value="${requestScope.producto.nombre}" class="form-control">
        </div>
        <c:if test="${requestScope.errores != null && requestScope.errores.containsKey('nombre')}">
            <div style="color:red;">${requestScope.errores.nombre}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="precio" class="col-form-label col-sm-2">Precio</label>
        <div class="col-sm-4">
            <input type="number" name="precio" id="precio"
                   value="${requestScope.producto.precio > 0? requestScope.producto.precio: ""}" class="form-control">
        </div>
        <c:if test="${requestScope.errores != null && not empty requestScope.errores.precio}">
            <div style="color:red;">${requestScope.errores.precio}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="sku" class="col-form-label col-sm-2">Sku</label>
        <div class="col-sm-4">
            <input type="text" name="sku" id="sku" value="${requestScope.producto.sku}" class="form-control">
        </div>
        <c:if test="${requestScope.errores != null && not empty requestScope.errores.sku}">
            <div style="color:red;">${requestScope.errores.sku}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="fecha_registro" class="col-form-label col-sm-2">Fecha Registro</label>
        <div class="col-sm-4">
            <input class="form-control" type="date" name="fecha_registro" id="fecha_registro"
                   value="${requestScope.producto.fechaRegistro != null? requestScope.producto.fechaRegistro.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")): ""}">
        </div>
        <c:if test="${requestScope.errores != null && not empty requestScope.errores.fecha_registro}">
            <div style="color:red;">${requestScope.errores.fecha_registro}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="categoria" class="col-form-label col-sm-2">Categoria</label>
        <div class="col-sm-4">
            <select name="categoria" id="categoria" class="form-select">
                <option value="">--- seleccionar ---</option>
                <c:forEach items="${requestScope.categorias}" var="c">
                    <option value="${c.id}" ${c.id.equals(requestScope.producto.categoria.id)? "selected": ""}>${c.nombre}</option>
                </c:forEach>
            </select>
        </div>
        <c:if test="${requestScope.errores != null && not empty requestScope.errores.categoria}">
            <div style="color:red;">${requestScope.errores.categoria}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <div>
            <input class="btn btn-primary" type="submit"
                   value="${requestScope.producto.id!=null && requestScope.producto.id>0? "Editar": "Crear"}">
        </div>
    </div>
    <input type="hidden" name="id" value="${requestScope.producto.id}">
</form>

<jsp:include page="layout/footer.jsp"/>
