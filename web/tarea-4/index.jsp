<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 15/1/2024
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cambiar color por cookies</title>
</head>
<body>
<h3 style="color: ${cookie.color.getValue()}">Tarea 4: cambiar el color de los textos</h3>

<p style="color: ${cookie.color.getValue()}">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>

<form action="${pageContext.request.contextPath}/tarea-4/cambiar-color">
    <label for="color">Seleccione un color: </label>
    <select name="color" id="color" >
        <option value="blue">Azul</option>
        <option value="red">Rojo</option>
        <option value="green">Verde</option>
        <option value="aqua">Aqua</option>
        <option value="BlueViolet">Violeta</option>
        <option value="Gray">Gris</option>
        <option value="Cyan">Cyan</option>
    </select>
    <input type="submit" value="Cambiar">
</form>
</body>
</html>
