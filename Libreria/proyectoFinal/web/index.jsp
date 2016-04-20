

<%@page import="dao.orm.Usuario"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/menu2.css"/>

        <title>Principal</title>
    </head>
    <body>
               
        <%Usuario usuarioSESION = (Usuario) session.getAttribute("Objeto usuario");%>
                <% if (session.getAttribute("Objeto usuario") != null && usuarioSESION.getTipo() == 0) {%>

                <jsp:include page="plantilla/menuUser_logout.jspf"></jsp:include>

        <%} else if (session.getAttribute("Objeto usuario") != null && usuarioSESION.getTipo() == 1) {%>
        <jsp:include page="plantilla/menuAdmin.jspf"></jsp:include>
       
          <%                } else if (session.getAttribute("Objeto usuario") == null) {%>
        
          <jsp:include page="plantilla/menuUser.jspf"></jsp:include>
                 <% }%>

        <div id="slider">  
            <div id="mask">  

                <ul>
                    <li id="first" class="primeraAnimacion"> 
                        <a href="#"> <img src="Imagen/slider/negro/ruido/1.jpg"> </a>
                    </li>

                    <li id="second" class="segundaanimacion">
                        <a href="#"> <img src="Imagen/slider/negro/ruido/2.jpg" > </a>
                    </li>

                    <li id="third" class="terceraanimacion">
                        <a href="#"> <img src="Imagen/slider/negro/ruido/3.jpg"/> </a>
                    </li>
                    <li id="fourth" class="cuartaanimacion">
                        <a href="#"> <img src="Imagen/slider/negro/ruido/4.jpg"> </a>
                    </li>
                </ul>
            </div>  
            <div class="progress-bar"></div>
        </div> <!--Fin capa cuerpo-->
        <div class="resultadoUser">
            <%
                if (session.getAttribute("Objeto usuario") != null) {
                    Usuario usuario = (Usuario) session.getAttribute("Objeto usuario");
                    String resp = (String) session.getAttribute("RESP");
                    if (resp == "true") {

                        String buffer = "";
                        buffer += "<h1><center>" + session.getAttribute("MENSAJE") + "</center></h1>";
                        out.print(buffer);
                        //resp = null;
                    } else {
                        out.print("<h1><center>El Usuario o la Contraseña son incorrectos</h1></center>");
                        //resp = null;
                    }
                }
            %>

        </div>

        <jsp:include page="plantilla/pie_pagina.jsp"></jsp:include>

    </body>
</html>
