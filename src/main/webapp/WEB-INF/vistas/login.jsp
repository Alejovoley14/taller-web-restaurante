<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<t:layout>

    <jsp:attribute name="styles">
        <style type="text/css">
            /*SI FUERA NECESARIO AGREGAR JQUERY O ESTILOS ESTA ES LA MANERA USANDO LOS ATTRIBUTOS DEL LAYOUT*/
        </style>
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <script type="text/javascript">
            //SI FUERA NECESARIO AGREGAR JQUERY O ESTILOS ESTA ES LA MANERA USANDO LOS ATTRIBUTOS DEL LAYOUT


            <%--function statusChangeCallback(response) {--%>


                <%--if (response.status === 'connected') {--%>
<%--console.log(response);--%>
                    <%--FB.api('/me', {locale: 'es_LA', fields: 'name, email'},--%>
                        <%--function (responseApi) {--%>
                            <%--console.log(response);--%>
                            <%--var data = {--%>
                                <%--id: responseApi.id,--%>
                                <%--email: responseApi.email,--%>
                                <%--accessToken: response.authResponse.accessToken,--%>
                                <%--expiresIn: response.authResponse.expiresIn,--%>
                                <%--socialType: "facebook",--%>
                                <%--_csrf:"${_csrf.token}"--%>
                            <%--};--%>
<%--//                            $.post( "/socialLogin", data);--%>
<%--//                            $.get( "/usuario/social"); contentType: "application/x-www-form-urlencoded; charset=UTF-8",--%>
                            <%--$.ajax({--%>
                                <%--url: 'usuario/social',--%>
                                <%--type: "POST",--%>
                                <%--contentType: "application/json",--%>
                                <%--data:data,--%>
                                <%--success: function (resposeJsonObject) {--%>
                                    <%--// Success Action--%>
                                <%--}--%>
                            <%--});--%>
                        <%--}--%>
                    <%--);--%>


                <%--} else {--%>

                <%--}--%>
            <%--}--%>


            <%--function checkLoginState() {--%>
                <%--FB.getLoginStatus(function (response) {--%>
                    <%--statusChangeCallback(response);--%>
                <%--});--%>
            <%--}--%>


            <%--window.fbAsyncInit = function () {--%>
                <%--FB.init({--%>
                    <%--appId: '269884806811458',--%>
                    <%--cookie: true,--%>
                    <%--xfbml: true,--%>
                    <%--version: 'v2.9'--%>
                <%--});--%>

                <%--FB.getLoginStatus(function (response) {--%>
                    <%--statusChangeCallback(response);--%>
                <%--});--%>

<%--//                FB.login(function (response) {--%>
<%--//                    console.log(response);--%>
<%--//                }, {scope: 'email'});--%>

            <%--};--%>

            <%--// Load the SDK asynchronously--%>
            <%--(function (d, s, id) {--%>
                <%--var js, fjs = d.getElementsByTagName(s)[0];--%>
                <%--if (d.getElementById(id)) return;--%>
                <%--js = d.createElement(s);--%>
                <%--js.id = id;--%>
                <%--js.src = "//connect.facebook.net/es_LA/sdk.js";--%>
                <%--fjs.parentNode.insertBefore(js, fjs);--%>
            <%--}(document, 'script', 'facebook-jssdk'));--%>


        </script>
    </jsp:attribute>

    <jsp:body>
        <div id="fb-root"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">Registrarse</div>
                        <div class="panel-body">
                            <th:form class="form-horizontal" action="CrearUsuario" method="POST"
                                     modelAttribute="usuario">
                                <div class="form-group">
                                    <label for="email" class="col-md-4 control-label">Usuario</label>
                                    <div class="col-md-6">
                                        <c:choose>
                                            <c:when test="${usuario == null}">
                                                <input id="email" type="email" class="form-control" name="email"
                                                       value="" required>
                                            </c:when>
                                            <c:when test="${usuario != null}">
                                                <th:input path="email" cssClass="form-control"></th:input>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-4 control-label">Contraseña</label>
                                    <div class="col-md-6">
                                        <input id="password" type="password" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="verifyPassword" class="col-md-4 control-label">Confirmar
                                        Contraseña</label>
                                    <div class="col-md-6">
                                        <input id="verifyPassword" type="password" class="form-control"
                                               name="verifyPassword" required>
                                    </div>
                                </div>
                                <c:if test="${not empty error}">
                                    <div class="alert alert-danger">
                                        <h4><span class="glyphicon glyphicon-exclamation-sign"></span> ${error}</h4>
                                    </div>
                                </c:if>
                                <c:if test="${not empty success}">
                                    <div class="alert alert-success">
                                        <h4><span class="glyphicon glyphicon-exclamation-sign"></span> ${success}</h4>
                                    </div>
                                </c:if>
                                <div class="row">

                                    <div class="col-md-6 col-md-offset-4">
                                        <button type="submit" class="btn btn-info">
                                            Registrarse
                                        </button>
                                    </div>
                                </div>
                                <hr>


                            </th:form>
                            <div class="row">
                                <p class="lead">
                                    Tambien podes usar tu red social favorita
                                </p>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                        <%--<div class="fb-login-button" data-max-rows="1" data-size="medium"--%>
                                        <%--data-button-type="continue_with" data-show-faces="true"--%>
                                        <%--data-auto-logout-link="false" data-use-continue-as="true"></div>--%>
                                    <form action="/connect/facebook" method="POST">
                                        <input type="hidden" name="scope" value="user_posts" />
                                        <div class="formInfo">
                                            <p>You aren't connected to Facebook yet. Click the button to connect this application with your Facebook account.</p>
                                        </div>
                                        <p><button type="submit">Connect to Facebook</button></p>
                                    </form>
                                        <%--<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">--%>
                                        <%--</fb:login-button>--%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>

</t:layout>