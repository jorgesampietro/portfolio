

<%@page import="dao.orm.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/menu2.css"/>
        <%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <title>Pagina Admin</title>
    </head>
    <body>
        <%Usuario usuarioSESION = (Usuario) session.getAttribute("Objeto usuario");%>
        <% if (usuarioSESION.getTipo() == 1) { %>
        <jsp:include page="plantilla/menuAdmin.jspf"></jsp:include>

            <form action="Controlador" method="post">
                <input type="hidden" name="ACTION" value="USUARIO.LOGIN"/>


            </form>
            <div class="resultado">

            <%
                Usuario usuario = (Usuario) session.getAttribute("USUARIO");

                if (usuario != null) {

                    String buffer = "";
                    buffer += "<h1><center>" + session.getAttribute("MENSAJE") + "</center></h1>";
                    out.print(buffer);
                }

            %>


        </div>

        <jsp:include page="plantilla/pie_pagina.jsp"></jsp:include>
        <% }%>
    </body>
</html>
