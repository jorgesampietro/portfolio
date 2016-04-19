


<!DOCTYPE html>
<html>
    <head>
        <%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <link href="newcss.css" type="text/css" rel="stylesheet">
        <title>libro</title>
    </head>
    <body>
        <jsp:include page="menu.jspf"></jsp:include>

        <div id="divInscribir" name="DIVINSCRIBIR">
            <form action="ControladorLibro" method="post">
                <input type="hidden" name="ACTION" value="PRODUCTO.ADD"/>

                <input type="text" id="ISBN" name="ISBN" size="50"
                       value=""
                       placeholder="ISBN"
                       required
                       autofocus/>
                </br>
                <input type="text" id="TITULO" name="TITULO" class="formulProductos"
                       value=""
                       placeholder="TITULO"
                       required/>
                </br>
                <input type="text" id="AUTOR" name="AUTOR" class="formulProductos"
                       value=""
                       placeholder="AUTOR"
                       required/>
                </br>

                <input type="number" id="CANTIDAD" name="CANTIDAD" class="formulProductos"
                       value=""
                       placeholder="Precio"
                       required/>
                </br>

                <input type="number" id="PRECIO" name="PRECIO" class="formulProductos"
                       value=""
                       placeholder="PRECIO"
                       required/>
                </br>

                <input type="submit" value="ENTER" class="formulProductos" id="BOTON"/>
            </form>


        </div>
    </body>
</html>
