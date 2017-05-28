<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:layout>
    <jsp:attribute name="scripts">
        <jsp:include page="scripts.jsp"></jsp:include>
    </jsp:attribute>
    <jsp:body>
        <th:form class="form-horizontal" action="/cliente/add" method="POST" modelAttribute="cliente">
            <jsp:include page="createeditpartial.jsp"></jsp:include>
        </th:form>
    </jsp:body>
</t:layout>
