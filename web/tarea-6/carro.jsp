<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carro de Compras</title>
</head>
<body>
<h1>Carro de Compras</h1>
<c:choose>

    <c:when test="${sessionScope.carro == null || sessionScope.carro.items.isEmpty()}">
        <p>¡Lo sentimos no hay productos en el carro de compras!</p>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/tarea-6/actualizar-carro" method="post">
            <table>
                <tr>
                    <th>id</th>
                    <th>nombre</th>
                    <th>precio</th>
                    <th>cantidad</th>
                    <th>total</th>
                    <th>borrar</th>
                </tr>
                <c:forEach items="${sessionScope.carro.items}" var="item">
                    <tr>
                        <input type="hidden" name="idProducto" value="${item.producto.id}">
                        <td>
                                ${item.producto.id}
                        </td>
                        <td>
                                ${item.producto.nombre}
                        </td>
                        <td>
                                ${item.producto.precio}
                        </td>
                        <td>
                            <label>
                                <input type="text" name="cantidad" value="${item.cantidad}">
                            </label>
                        </td>
                        <td>
                                ${item.getImporte()}
                        </td>
                        <td>
                            <label>
                                <input type="checkbox" name="borrarProducto" value="${item.producto.id}">
                            </label>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="4" style="text-align: right">Total:</td>
                    <td>
                        ${sessionScope.carro.getTotal()}
                    </td>
                </tr>
            </table>
            <input type="submit" value="actualizar carro">
        </form>
    </c:otherwise>
</c:choose>
<p><a href="${pageContext.request.contextPath}/tarea-6/productos">seguir comprando</a></p>
<p><a href="index.jsp">volver</a></p>
</body>
</html>