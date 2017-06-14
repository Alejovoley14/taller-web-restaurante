<%--
  Created by IntelliJ IDEA.
  User: spardo
  Date: 14/6/2017
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<t:layout>

    <jsp:body>
        <div class="container">
            <th:form class="form-horizontal" action="${context}/carta/add" method="POST" modelAttribute="carta">
                <jsp:include page="createeditpartial.jsp"></jsp:include>
            </th:form>
        </div>
    </jsp:body>
</t:layout>

