<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<t:layout>

    <jsp:body>
		 <div class="row">
		 	<th:form class="form-horizontal pull-left" action="/taller-web-restaurante/restaurant/create" method="GET" modelAttribute="restaurant">
	             <div class="col-sm-offset-9 col-sm-3">
				     <button class="btn btn-primary pull-left" type="submit">Agregar</button>
				 </div>   
            </th:form>
			 
		</div>
	     
    	    
    	    
    	    <table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre Fantasia</th>
					<th>Razon Social</th>
					<th>Cuit</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="restaurant" items="${lista}">
			    <tr>
				<td>${restaurant.getId()}</td>
				<td>${restaurant.getNombreFantasia()}</td>
				<td>${restaurant.getRazonSocial()}</td>
				<td>${restaurant.getCuit()}</td>
				<td>
                <c:forEach var="framework" items="${user.framework}"
                                                             varStatus="loop">
					${framework}
    				        <c:if test="${not loop.last}">,</c:if>
				  </c:forEach>
                                </td>
				<td>
				
				  <spring:url value="/restaurant/${restaurant.getId()}/delete" var="deleteUrl" />
				  <spring:url value="/restaurant/edit/${restaurant.getId()}" var="updateUrl" />

				  
				  <button class="btn btn-primary"
                                          onclick="location.href='${updateUrl}'">Update</button>
				  <button class="btn btn-danger"
                                          onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                                </td>
			    </tr>
			</c:forEach>
		</table>
    </jsp:body>
</t:layout>