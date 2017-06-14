<%--
  Created by IntelliJ IDEA.
  User: spardo
  Date: 14/6/2017
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<t:layout>
    <jsp:body>
        <div class="container">
            <th:form class="form-horizontal" action="${context}/carta/update" method="POST" modelAttribute="carta">
                <th:input path="id" type="hidden"></th:input>
                <jsp:include page="createeditpartial.jsp"></jsp:include>
            </th:form>
        </div>
    </jsp:body>
</t:layout>

