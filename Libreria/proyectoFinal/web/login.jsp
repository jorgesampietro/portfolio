

<%@page import="dao.orm.Usuario"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/menu2.css"/>
        <%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <title>Login</title>
    </head>
    <script type="text/javascript">
        function validacion() {
            user = document.getElementById("USER").value;
            if (user == null || user.length == 0) {
                document.formularioUsuario.USER.focus();
                alert("Debe rellenar el campo Usuario");
                return false;
            }
            pass = document.getElementById("PASS").value;
            if (pass == null || pass.length == 0) {
                document.formularioUsuario.PASS.focus();
                alert("Debe rellenar el campo Password");
                return false;
            }
            document.getElementById("formularioUsuario").submit();
        }

    </script>
    <body>
        <jsp:include page="plantilla/menuUser.jspf"></jsp:include>
            <div class="contenededor">
                <form action="Controlador" method="post" name="formularioUsuario" id="formularioUsuario">
                    <input type="hidden" name="ACTION" value="USUARIO.LOGIN"/>

                    <div class="userYpass">
                        <table class="tabla">
                            <tr>
                                <td><label for="USER">USUARIO:</label></td>
                                <td></td>
                                <td><input type="text" id="USER" name="USER"
                                           value=""
                                           placeholder="Nombre de Usuario"
                                           required
                                           autofocus/></td>
                            </tr>
                            <tr>
                                <td><label for="PASS">PASS:</label></td>
                                <td></td>
                                <td>   <input type="password" id="PASS" name="PASS"
                                              value=""
                                              placeholder="Contraseña"
                                              required/></td>
                            </tr>

                        </table>


                    </div>
                    <div class="boton">
                        <input type="button" value="Login"  class="button" onclick="validacion()"/>
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
