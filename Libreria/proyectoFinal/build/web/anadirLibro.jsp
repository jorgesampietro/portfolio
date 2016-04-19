

<%@page import="dao.orm.Libro"%>
<%@page import="dao.orm.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/menu2.css"/>
        <%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <title>Añadir usuario</title>
    </head>
    <script type="text/javascript">
        function validacion() {
            isbn = document.getElementById("ISBN").value;
            if (isbn == null || isbn.length == 0 || /^\s+$/.test(isbn)) {
                document.formularioLibro.ISBN.focus();
                alert("Debe rellenar el campo ISBN");
                return false;
            } else if (isNaN(isbn)) {
                document.formularioLibro.ISBN.focus();
                alert("Introduzca un valor numérico en ISBN");
                return false;
            }

            titulo = document.getElementById("TITULO").value;
            if (titulo == null || titulo.length == 0) {
                document.formularioLibro.TITULO.focus();
                alert("Debe rellenar el campo Titulo");
                return false;
            }
            autor = document.getElementById("AUTOR").value;
            if (autor == null || autor.length == 0) {
                document.formularioLibro.AUTOR.focus();
                alert("Debe rellenar el campo Autor");
                return false;
            }

            cantidad = document.getElementById("CANTIDAD").value;
            if (cantidad == null || cantidad.length == 0 || /^\s+$/.test(cantidad)) {
                document.formularioLibro.CANTIDAD.focus();
                alert("Debe rellenar el campo Cantidad");
                return false;
            } else if (isNaN(cantidad)) {
                document.formularioLibro.CANTIDAD.focus();
                alert("Introduzca un valor numérico en Cantidad");
                return false;
            } else if (cantidad != parseInt(cantidad)) {
                document.formularioLibro.CANTIDAD.focus();
                alert("Introduzca un número entero en Cantidad");
                return false;
            }

            precio = document.getElementById("PRECIO").value;
            if (precio == null || precio.length == 0 || /^\s+$/.test(precio)) {
                document.formularioLibro.PRECIO.focus();
                alert("Debe rellenar el campo Precio");
                return false;
            } else if (isNaN(precio)) {
                document.formularioLibro.PRECIO.focus();
                alert("Introduzca un valor numérico en Precio");
                return false;
            }
            document.getElementById("formularioLibro").submit();

        }

    </script>

    <body>
        <%Usuario usuarioSESION = (Usuario) session.getAttribute("Objeto usuario");%>
        <% if (usuarioSESION.getTipo() == 1) { %>
        <jsp:include page="plantilla/menuAdmin.jspf"></jsp:include>
            <div class="contenededor">
                <form action="Controlador" method="post" name="formularioLibro" id="formularioLibro">
                    <input type="hidden" name="ACTION" value="LIBRO.ADD"/>

                    <div class="userYpass">
                        <div class="tabla" >
                            <table>
                                <tr>
                                    <td><label for="ISBN">ISBN:</label></td>    
                                    <td></td>    
                                    <td> <input type="text" id="ISBN" name="ISBN"
                                                value=""
                                                placeholder="ISBN"
                                                required
                                                autofocus/></td>    
                                </tr>
                                <tr>
                                    <td><label for="TITULO">TITULO:</label></td>    
                                    <td></td>    
                                    <td> <input type="text" id="TITULO" name="TITULO"
                                                value=""
                                                placeholder="Titulo"
                                                required
                                                autofocus/></td>    
                                </tr>
                                <tr>
                                    <td> <label for="AUTOR">AUTOR:</label></td>    
                                    <td></td>    
                                    <td><input type="text" id="AUTOR" name="AUTOR"
                                               value=""
                                               placeholder="Autor"
                                               required
                                               autofocus/></td>    
                                </tr>
                                <tr>
                                    <td><label for="CANTIDAD">CANTIDAD:</label></td>    
                                    <td></td>    
                                    <td><input type="text" id="CANTIDAD" name="CANTIDAD"
                                               value=""
                                               placeholder="Cantidad"
                                               required
                                               autofocus/></td>    
                                </tr>
                                <tr>
                                    <td><label for="PASS">PRECIO:</label></td>    
                                    <td></td>    
                                    <td><input type="text" id="PRECIO" name="PRECIO"
                                               value=""
                                               placeholder="Precio"
                                               required/></td>    
                                </tr>


                            </table>
                        </div>

                        <div class="boton">
                            <input type="button" value="Añadir"  class="button" onclick="validacion()"/>
                        </div>
                    </div><!--Fin capa cuerpo-->
                </form>
            <%
                Libro libro = (Libro) request.getAttribute("PRODUCTO");

                if (libro != null) {

                    String buffer = "";
                    buffer += "<h1><center>" + request.getAttribute("MENSAJE") + "</center></h1>";
                    out.print(buffer);
                }

            %>

        </div>
        <jsp:include page="plantilla/pie_pagina.jsp"></jsp:include>
        <% }%>
    </body>
</html>
