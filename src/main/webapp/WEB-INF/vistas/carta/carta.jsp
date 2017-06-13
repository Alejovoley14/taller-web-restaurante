<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
        </script>
    </jsp:attribute>
    
<jsp:body>
<<h3 class="form-signin-heading">Menu/Carta del lado del restaurant</h3>
<table class="table">

<tbody>

        <TR><TH scope="row">id Menu</TH> <TH scope="row">Titulo</TH> <TH scope="row">Descripcion</TH><TH scope="row">Precio</TH><TH scope="row">  </TH></TR>	
	<TR><TD>1</TD> <TD>titulo 1</TD>
                     
                    <TD><select name="menu"> 
                        <option value= " "> Seleccionar menu</option>
                        <option value= "gaseosa"> menu 1</option> 
                        <option value= "agua"> menu 2</option> 
                        <option value= "vino">menu 3</option>
                        </select></TD>
                        
                       <TD>150 </TD>
                     
                      <TD><button type="button" class="btn btn-warning">Editar</button></TD><TD><button type="button" class="btn btn-danger">Eliminar</button></TD></TR>	
        <TR> <TD>2</TD> <TD>titulo 2</TD>
                     
                    <TD><select name="menu"> 
                        <option value= " "> Seleccionar menu</option>
                        <option value= "gaseosa"> menu 1</option> 
                        <option value= "agua"> menu 2</option> 
                        <option value= "vino">menu 3</option>
                        </select></TD>
                        
                       <TD>180 </TD><TD><button type="button" class="btn btn-warning">Editar</button></TD><TD><button type="button" class="btn btn-danger">Eliminar</button></TD></TR>
        <TR> <TD>3</TD> <TD>titulo 3</TD>
                     
                    <TD><select name="menu"> 
                        <option value= " "> Seleccionar menu</option>
                        <option value= "gaseosa"> menu 1</option> 
                        <option value= "agua"> menu 2</option> 
                        <option value= "vino">menu 3</option>
                        </select></TD>
                        
                       <TD>200 </TD><TD><button type="button" class="btn btn-warning">Editar</button></TD><TD><button type="button" class="btn btn-danger">Eliminar</button></TD></TR>
        <TR><TD><button type="button" class="btn btn-info">Agregar Menu</button></TD></TR>
</tbody>

</table>
</jsp:body>
</t:layout>
