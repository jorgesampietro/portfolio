

<%@page import="java.util.ArrayList"%>
<%@page import="dao.orm.Libro"%>
<%@page import="dao.orm.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/menu2.css"/>
        <%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <title>Buscar</title>
    </head>
    <script type="text/javascript">
        function validacion() {
            modificarISBN = document.getElementById("modificarISBN").value;
            if (modificarISBN == null || modificarISBN.length == 0 || /^\s+$/.test(modificarISBN)) {
                document.formularioModificar.modificarISBN.focus();
                alert("Debe rellenar el campo ISBN");
                return false;
            } else if (isNaN(modificarISBN)) {
                document.formularioModificar.modificarISBN.focus();
                alert("Introduzca un valor numérico en ISBN");
                return false;
            }

            modificarTitulo = document.getElementById("modificarTitulo").value;
            if (modificarTitulo == null || modificarTitulo.length == 0) {
                document.formularioModificar.modificarTitulo.focus();
                alert("Debe rellenar el campo Titulo");
                return false;
            }
            modificarAutor = document.getElementById("modificarAutor").value;
            if (modificarAutor == null || modificarAutor.length == 0) {
                document.formularioModificar.modificarAutor.focus();
                alert("Debe rellenar el campo Autor");
                return false;
            }

            modificarCantidad = document.getElementById("modificarCantidad").value;
            if (modificarCantidad == null || modificarCantidad.length == 0 || /^\s+$/.test(modificarCantidad)) {
                document.formularioModificar.modificarCantidad.focus();
                alert("Debe rellenar el campo Cantidad");
                return false;
            } else if (isNaN(modificarCantidad)) {
                document.formularioModificar.modificarCantidad.focus();
                alert("Introduzca un valor numérico en Cantidad");
                return false;
            } else if (modificarCantidad != parseInt(modificarCantidad)) {
                document.formularioModificar.modificarCantidad.focus();
                alert("Introduzca un número entero en Cantidad");
                return false;
            }

            modificarPrecio = document.getElementById("modificarPrecio").value;
            if (modificarPrecio == null || modificarPrecio.length == 0 || /^\s+$/.test(modificarPrecio)) {
                document.formularioModificar.modificarPrecio.focus();
                alert("Debe rellenar el campo Precio");
                return false;
            } else if (isNaN(modificarPrecio)) {
                document.formularioModificar.modificarPrecio.focus();
                alert("Introduzca un valor numérico en Precio");
                return false;
            }
            document.getElementById("formularioModificar").submit();

        }

    </script>
    <body>
        <%Usuario usuarioSESION = (Usuario) session.getAttribute("Objeto usuario");%>
        <% if (usuarioSESION.getTipo() == 1) { %>
        <jsp:include page="plantilla/menuAdmin.jspf"></jsp:include>
            <div class="contenededor">
                <form action="Controlador" method="post">
                    <input type="hidden" name="ACTION" value="LIBRO.FIND"/>

                    <div class="userYpass">
                        <div class="tabla" >
                            <table>
                                <tr>
                                    <td><label for="ISBN">ISBN:</label></td>    
                                    <td></td>    
                                    <td> <input type="text" id="ISBN" name="ISBN"
                                                value=""
                                                placeholder="ISBN"
                                                autofocus/>
                                    </td>    
                                </tr>
                                <tr>
                                    <td><label for="TITULO">TITULO:</label></td>    
                                    <td></td>    
                                    <td> <input type="text" id="TITULO" name="TITULO"
                                                value=""
                                                placeholder="Titulo"
                                                autofocus/>
                                    </td>    
                                </tr>
                                <tr>
                                    <td> <label for="AUTOR">AUTOR:</label></td>    
                                    <td></td>    
                                    <td><input type="text" id="AUTOR" name="AUTOR"
                                               value=""
                                               placeholder="Autor"
                                               autofocus/>
                                    </td>    
                                </tr>
                                <tr>
                                    <td><label for="CANTIDAD">CANTIDAD:</label></td>    
                                    <td></td>    
                                    <td><input type="text" id="CANTIDAD" name="CANTIDAD"
                                               value=""
                                               placeholder="Cantidad"
                                               autofocus/>
                                    </td>    
                                </tr>
                                <tr>
                                    <td><label for="PASS">PRECIO:</label></td>    
                                    <td></td>    
                                    <td><input type="text" id="PRECIO" name="PRECIO"
                                               value=""
                                               placeholder="Precio"/>
                                    </td>    
                                </tr>


                            </table>
                        </div>

                        <div class="boton">
                            <input type="submit" value="Buscar"  class="button"/>
                        </div>
                    </div><!--Fin capa cuerpo-->
                </form>

            </div>

        <%

            if (session.getAttribute("lista") != null) {
                ArrayList<Libro> listaLibro = new ArrayList();
                listaLibro = (ArrayList) session.getAttribute("lista");

        %>



        <table  class="tablaListar">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ISBN</th>
                    <th>Titulo</th>
                    <th>Autor</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <%                    for (int i = 0; i < listaLibro.size(); i++) {
            %>
            <tbody>
            <td>
                <%= listaLibro.get(i).getId_libro()%>
            </td>
            <td>
                <%= listaLibro.get(i).getIsbn()%>

            </td>
            <td>
                <%= listaLibro.get(i).getTitulo()%>

            </td>
            <td>
                <%= listaLibro.get(i).getAutor()%>

            </td>
            <td>
                <%= listaLibro.get(i).getCantidad()%>
            </td>
            <td>
                <%= listaLibro.get(i).getPrecio()%>
            </td>
            <td>
                <a href="javascript:editar(<%= listaLibro.get(i).getId_libro()%>, <%= listaLibro.get(i).getIsbn()%>,
                   '<%= listaLibro.get(i).getTitulo()%>','<%= listaLibro.get(i).getAutor()%>',<%= listaLibro.get(i).getCantidad()%>,<%= listaLibro.get(i).getPrecio()%>
                   )" ><span>Editar</span></a>
            </td>
            <td>
                <a href="javascript:borrar(<%= listaLibro.get(i).getId_libro()%>)" ><span>Borrar</span></a>
            </td>
        </tbody>    

        <%
            }
        %>
    </table>  
    <%
    } else {
    %>


    <%
        if (request.getAttribute("PRODUCTO") != null) {

    %>
    <div class="resultadoBuscar">
        <%            String buffer = "";
            buffer += "<h1><center>" + request.getAttribute("MENSAJE") + "</center></h1>";

            out.print(buffer);
        %>
    </div>       
    <%
            }
        }
    %>

    <form action="Controlador" method="post" id="formularioBorrar">
        <input type="hidden" name="ACTION" value="LIBRO.DELETE"/>
        <input type="hidden" name="IDLIBRO" id="ELIMINAR"/>
    </form>


    <script type="text/javascript">
        function editar(idLibro, isbn, titulo, autor, cantidad, precio) {
            document.getElementById('tablaModificar').style.display = 'block';
            document.getElementById('modificarIDlibro').value = idLibro;
            document.getElementById('modificarISBN').value = isbn;
            document.getElementById('modificarTitulo').value = titulo;
            document.getElementById('modificarAutor').value = autor;
            document.getElementById('modificarCantidad').value = cantidad;
            document.getElementById('modificarPrecio').value = precio;
        }

        function borrar(idLibro) {
            alert("Has elegido borrar el ID: " + idLibro);
            document.getElementById('ELIMINAR').value = idLibro;
            var form = document.getElementById('formularioBorrar')
            form.submit();
        }



    </script>


    <div id="tablaModificar" class="divModificar" style="display:none;">

        <form action="Controlador" class="form" method="post" name="formularioModificar" id ="formularioModificar">

            <input type="hidden" name="ACTION" value="LIBRO.UPDATE"/>

            <table>
                <tr>
                    <td>Id Libro: </td>
                    <td></td>
                    <td><input type="text" size="20" id="modificarIDlibro" name="modificarIDlibro"
                               value=""
                               placeholder="Id"
                               required
                               autofocus
                               readonly/></td>
                </tr>
                <tr>
                    <td>ISBN:</td>
                    <td></td>
                    <td><input type="text" size="20" id="modificarISBN" name="modificarISBN"
                               value=""
                               placeholder="ISBN"/>
                    </td>
                </tr>
                <tr>
                    <td>Titulo:</td>
                    <td></td>
                    <td><input type="text" size="20" id="modificarTitulo" name="modificarTitulo"
                               value=""
                               placeholder="Titulo"
                               required
                               autofocus/>
                    </td>
                </tr>
                <tr>
                    <td>Autor: </td>
                    <td></td>
                    <td><input type="text" size="20" id="modificarAutor" name="modificarAutor"
                               value=""
                               placeholder="Autor"
                               required
                               autofocus/>
                    </td>
                </tr>
                <tr>
                    <td>Cantidad:</td>
                    <td></td>
                    <td><input type="text" size="20" id="modificarCantidad" name="modificarCantidad"
                               value=""
                               placeholder="Cantidad"
                               required
                               autofocus/>
                    </td>
                </tr>
                <tr>
                    <td>Precio: </td>
                    <td></td>
                    <td><input type="text" size="20" id="modificarPrecio" name="modificarPrecio"
                               value=""
                               placeholder="Precio"
                               required
                               autofocus/>
                    </td>
                </tr>

            </table>


            <input type="button" value="Modificar" class="button" onclick="validacion()"/>

        </form>
    </div>

    <%
        if (request.getAttribute("PRODUCTO") != null) {
    %>
    <div class="resultadoActualizar">
        <%
            String buffer = "";
            buffer += "<h1><center>" + request.getAttribute("MENSAJE") + "</center></h1>";
            out.print(buffer);
        %>
    </div>
    <%
        }
    %>
    <jsp:include page="plantilla/pie_pagina.jsp"></jsp:include>
    <% }%>
</body>
</html>
