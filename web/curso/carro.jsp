<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp"/>
<%--@elvariable id="carro" type="com.curso.models.Carro"--%>
<h3>${requestScope.title}</h3>

<c:choose>
    <c:when test="${carro.items.isEmpty()}">
        <div class="alert alert-warning">Lo sentimos no hay productos en el carro de compras!</div>
    </c:when>
    <c:otherwise>
        <form name="formulary" action="${pageContext.request.contextPath}/carro/actualizar" method="post">
            <table class="table table-hover table-striped">
                <tr>
                    <th>id</th>
                    <th>nombre</th>
                    <th>precio</th>
                    <th>cantidad</th>
                    <th>total</th>
                    <th>borrar</th>
                </tr>
                <c:forEach items="${carro.items}" var="item">
                    <tr>
                        <td>${item.producto.id}</td>
                        <td>${item.producto.nombre}</td>
                        <td>${item.producto.precio}</td>
                        <td><label>
                            <input type="text" size="4" name="cant_${item.producto.id}" value="${item.cantidad}"/>
                        </label></td>
                        <td>${item.importe}</td>
                        <td><label>
                            <input type="checkbox" value="${item.producto.id}" name="deleteProductos"/>
                        </label></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="5" style="text-align: right">Total:</td>
                    <td>${carro.total}</td>
                </tr>
            </table>
            <a class="btn btn-primary" href="javascript:document.formulary.submit();">Actualizar</a>
        </form>
    </c:otherwise>
</c:choose>
<div class="my-2">
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/curso/index.jsp">volver</a>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/curso/productos">seguir comprando</a>
</div>

<jsp:include page="layout/footer.jsp"/>
