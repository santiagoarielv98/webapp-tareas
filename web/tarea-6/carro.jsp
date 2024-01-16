<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ page import="com.svillanueva.models.Carro" %>
<%@ page import="com.svillanueva.models.ItemCarro" %>

<%
    Carro carro = (Carro) session.getAttribute("carro");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carro de Compras</title>
</head>
<body>
<h1>Carro de Compras</h1>
<% if (carro == null || carro.getItems()
        .isEmpty()) {%>
<p>¡Lo sentimos no hay productos en el carro de compras!</p>
<%} else { %>
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
        <%for (ItemCarro item : carro.getItems()) {%>
        <tr>
            <input type="hidden" name="idProducto" value="<%=item.getProducto().getId()%>">
            <td><%=item.getProducto()
                    .getId()%>
            </td>
            <td><%=item.getProducto()
                    .getNombre()%>
            </td>
            <td><%=item.getProducto()
                    .getPrecio()%>
            </td>
            <td>
                <label>
                    <input type="text" name="cantidad" value="<%=item.getCantidad()%>">
                </label>
            </td>
            <td><%=item.getImporte()%>
            </td>
            <td>
                <label>
                    <input type="checkbox" name="borrarProducto" value="<%=item.getProducto().getId()%>">
                </label>
            </td>
        </tr>
        <%}%>
        <tr>
            <td colspan="4" style="text-align: right">Total:</td>
            <td><%=carro.getTotal()%>
            </td>
        </tr>
    </table>
    <input type="submit" value="actualizar carro">
</form>

<%}%>
<p><a href="${pageContext.request.contextPath}/tarea-6/productos">seguir comprando</a></p>
<p><a href="index.jsp">volver</a></p>
</body>
</html>