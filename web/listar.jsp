<%@ page import="com.svillanueva.models.Producto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 17/1/2024
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    @SuppressWarnings("unchecked")
    List<Producto> listaProducto = (List<Producto>) request.getAttribute("listaProducto");
    Optional<String> username = Optional.ofNullable((String) request.getSession().getAttribute("username"));

%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>¡Listado de Productos!</h1>

<% if (username.isPresent()) { %>
<div>Hola, <%=username.get()%> bienvenido</div>
<% } %>

<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>tipo</th>

        <% if (username.isPresent()) { %>
        <th>precio</th>
        <th>agregar</th>
        <% } %>

    </tr>
    <% for (Producto p : listaProducto) { %>
    <tr>
        <td><%= p.getId() %>
        </td>
        <td><%= p.getNombre() %>
        </td>
        <td><%= p.getCategoria().getNombre() %>
        </td>

        <% if (username.isPresent()) { %>
        <td><%= p.getPrecio() %>
        </td>
        <td><a href="${pageContext.request.contextPath}/tarea-6/agregar-carro<%= "?id=" + p.getId() %>">agregar al
            carro</a>
        </td>
        <% } %>

    </tr>
    <% } %>

</table>


</body>
</html>
