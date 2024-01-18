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
    Optional<String> username = Optional.of("santiago");
    //Optional.ofNullable((String) request.getSession().getAttribute("username"));

%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>¡Listado de Productos!</h1>

<div>Hola, <%=username.get()%> bienvenido</div>
<a href="${pageContext.request.contextPath}/producto/form">Crear [+] </a>

<table>
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>tipo</th>
        <th>precio</th>
        <th>agregar</th>
        <th>editar</th>
        <th>eliminar</th>
    </tr>
    <% for (Producto p : listaProducto) { %>
    <tr>
        <td><%= p.getId() %>
        </td>
        <td><%= p.getNombre() %>
        </td>
        <td><%= p.getCategoria()
                .getNombre() %>
        </td>

        <td><%= p.getPrecio() %>
        </td>
        <td><a href="${pageContext.request.contextPath}/tarea-6/agregar-carro<%= "?id=" + p.getId() %>">agregar al
            carro</a>
        </td>
        <td><a href="${pageContext.request.contextPath}/producto/form<%= "?id=" + p.getId() %>">editar</a>
        <td><a onclick="return confirm('Deseas Eliminar este producto');"
               href="${pageContext.request.contextPath}/producto/eliminar<%= "?id=" + p.getId() %>">eliminar</a>
    </tr>
    <% } %>

</table>


</body>
</html>
