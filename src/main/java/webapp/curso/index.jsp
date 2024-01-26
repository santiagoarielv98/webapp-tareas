<jsp:include page="layout/header.jsp"/>

<h3>${requestScope.title}</h3>

<ul class="list-group">
    <li class="list-group-item active">Menu de opciones</li>
    <li class="list-group-item"><a href="${pageContext.request.contextPath}/curso/usuarios">usuarios</a>
    </li>
    <li class="list-group-item"><a href="${pageContext.request.contextPath}/curso/productos">productos</a>
    </li>
    <li class="list-group-item"><a href="${pageContext.request.contextPath}/curso/login">login</a></li>
    <li class="list-group-item"><a href="${pageContext.request.contextPath}/curso/logout">logout</a></li>
    <li class="list-group-item"><a href="${pageContext.request.contextPath}/curso/carro/ver">ver carro</a></li>
</ul>

<jsp:include page="layout/footer.jsp"/>
