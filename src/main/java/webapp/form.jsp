<%@ page import="com.svillanueva.models.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.svillanueva.models.Producto" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 18/1/2024
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    @SuppressWarnings("unchecked")
    List<Categoria> listaCategorias = (List<Categoria>) request.getAttribute("listaCategorias");

    @SuppressWarnings("unchecked")
    Optional<Producto> producto = (Optional<Producto>) request.getAttribute("producto");

    @SuppressWarnings("unchecked")
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
%>
<html>
<head>
    <title>Formulario Producto</title>
</head>
<body>
<h1>Formulario Producto</h1>
<form action="${pageContext.request.contextPath}/producto/form" method="post">
    <input type="hidden" name="id" value="<%=producto.isPresent() ? producto.get().getId() : 0%>">
    <div>
        <label for="nombre">Nombre</label>
        <div>
            <input type="text" name="nombre" id="nombre"
                   value="<%= producto.isPresent() ? producto.get().getNombre() : ""%>">
        </div>
        <% if (errores != null && errores.containsKey("nombre")) { %>
        <span style="color: red"><%=errores.get("nombre")%></span>
        <% } %>
    </div>
    <div>
        <label for="precio">Precio</label>
        <div>
            <input type="number" name="precio" id="precio"
                   value="<%= producto.isPresent() ? producto.get().getPrecio() : ""%>">
        </div>
        <% if (errores != null && errores.containsKey("precio")) { %>
        <span style="color: red"><%=errores.get("precio")%></span>
        <% } %>
    </div>
    <div>
        <label for="sku">SKU</label>
        <div>
            <input type="text" name="sku" id="sku" value="<%= producto.isPresent() ? producto.get().getSku() : ""%>">
        </div>
        <% if (errores != null && errores.containsKey("sku")) { %>
        <span style="color: red"><%=errores.get("sku")%></span>
        <% } %>
    </div>
    <div>
        <label for="fecha_registro">Fecha Registro</label>
        <div>
            <input type="date" name="fecha_registro" id="fecha_registro"
                   value="<%= producto.isPresent() ? producto.get().getFechaRegistro() : ""%>"
            >
        </div>
        <% if (errores != null && errores.containsKey("fecha_registro")) { %>
        <span style="color: red"><%=errores.get("fecha_registro")%></span>
        <% } %>
    </div>
    <div>
        <label for="categoria">Categoria</label>
        <div>
            <select name="categoria" id="categoria">
                <option value="">Seleccionar</option>
                <% for (Categoria categoria : listaCategorias) {%>
                <option value="<%=categoria.getId()%>"
                        <%= producto.isPresent() && Objects.equals(producto.get()
                                .getCategoria()
                                .getId(), categoria.getId()) ? "selected" : ""%>
                >
                    <%=categoria.getNombre()%>
                </option>
                <% } %>
            </select>
        </div>
        <% if (errores != null && errores.containsKey("categoria")) { %>
        <span style="color: red"><%=errores.get("categoria")%></span>
        <% } %>
    </div>

    <div>
        <input type="submit" value="crear">
    </div>
</form>
</body>
</html>
