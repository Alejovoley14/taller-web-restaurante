<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:layout>
    <jsp:body>
        Bienvenido al home
        <security:authorize access="isAuthenticated()">
            authenticated as <security:authentication property="principal.username" />
        </security:authorize>
    </jsp:body>

</t:layout>
