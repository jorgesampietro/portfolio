package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.orm.Usuario;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/menu2.css\"/>\n");
      out.write("\n");
      out.write("        <title>Principal</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("       ");
      out.write("\n");
      out.write("         \n");
      out.write("        ");
Usuario usuarioSESION = (Usuario) session.getAttribute("Objeto usuario");
      out.write("\n");
      out.write("                ");
 if (session.getAttribute("Objeto usuario") != null && usuarioSESION.getTipo() == 0) {
      out.write("\n");
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "plantilla/menuUser_logout.jspf", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        ");
} else if (session.getAttribute("Objeto usuario") != null && usuarioSESION.getTipo() == 1) {
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "plantilla/menuAdmin.jspf", out, false);
      out.write("\n");
      out.write("       \n");
      out.write("          ");
                } else if (session.getAttribute("Objeto usuario") == null) {
      out.write("\n");
      out.write("        \n");
      out.write("          ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "plantilla/menuUser.jspf", out, false);
      out.write("\n");
      out.write("                 ");
 }
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"slider\">  \n");
      out.write("            <div id=\"mask\">  \n");
      out.write("\n");
      out.write("                <ul>\n");
      out.write("                    <li id=\"first\" class=\"primeraAnimacion\"> \n");
      out.write("                        <a href=\"#\"> <img src=\"Imagen/slider/negro/ruido/1.jpg\"> </a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li id=\"second\" class=\"segundaanimacion\">\n");
      out.write("                        <a href=\"#\"> <img src=\"Imagen/slider/negro/ruido/2.jpg\" > </a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li id=\"third\" class=\"terceraanimacion\">\n");
      out.write("                        <a href=\"#\"> <img src=\"Imagen/slider/negro/ruido/3.jpg\"/> </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li id=\"fourth\" class=\"cuartaanimacion\">\n");
      out.write("                        <a href=\"#\"> <img src=\"Imagen/slider/negro/ruido/4.jpg\"> </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>  \n");
      out.write("            <div class=\"progress-bar\"></div>\n");
      out.write("        </div> <!--Fin capa cuerpo-->\n");
      out.write("        <div class=\"resultadoUser\">\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "plantilla/pie_pagina.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
