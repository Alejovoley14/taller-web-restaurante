<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<footer class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <p class="navbar-text pull-left">©  <fmt:formatDate value="${date}" pattern="yyyy" /> - MesaVIP
            <a href="#" target="_blank" >Icono facebook</a>
        </p>

        <a href="#" class="navbar-btn btn-danger btn pull-right">
            <span class="glyphicon glyphicon-star"></span>  Boton derecha</a>
    </div>


</footer>
