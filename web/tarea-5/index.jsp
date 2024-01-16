<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 16/1/2024
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Tarea 5 - Session HTTP</title>
</head>
<body>
<h3>Tarea 5: Session HTTP</h3>
<p>Hola <%=session.getAttribute("nombre") != null ? session.getAttribute("nombre") : "anónimo" %> bienvenido a la tarea
    5
</p>
<form action="${pageContext.request.contextPath}/tarea-5/guardar-session" method="post">
    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" id="nombre">
    <input type="submit" value="Enviar">
</form>
</body>
</html>
