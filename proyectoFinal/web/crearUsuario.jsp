

<%@page import="dao.orm.Usuario"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/menu2.css"/>
        <%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="plantilla/menuAdmin.jspf"></jsp:include>
        <div class="contenededor">
            <form action="Controlador" method="post">
                <input type="hidden" name="ACTION" value="USUARIO.ADD"/>

                <div class="userYpass">
                    
                    <label for="USER">USUARIO:</label>
                        <input type="text" id="USER" name="USER"
                               value=""
                               placeholder="Nombre de Usuario"
                               required
                               autofocus/><br><br>
                    

                    
                        <label for="PASS">CONTRASEÑA:</label>
                        <input type="password" id="PASS" name="PASS"
                               value=""
                               placeholder="Contraseña"
                               required/><br><br>
                    
                    
                        <label for="PASS">TIPO USER:</label>
                        <input type="text" id="TIPO" name="TIPO"
                               value=""
                               placeholder="Tipo"
                               required/>
                    

                </div>
                <div class="boton">
                    <input type="submit" value="Crear Usuario"  class="button"/>
                </div>
            </form>
        </div><!--Fin capa cuerpo-->
        
         <%
            Usuario usuario = (Usuario) request.getAttribute("USUARIO");

            if (usuario != null) {

                String buffer = "";
                buffer += "<h1><center>" + request.getAttribute("MENSAJE") + "</center></h1>";
                out.print(buffer);
            }
        %>
        
        <jsp:include page="plantilla/pie_pagina.jsp"></jsp:include>
    </body>
</html>


