/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Action.Action;
import Controlador.Action.LibroAction;
import Controlador.Action.UsuarioAction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // RECUPERAR PARÁMETROS POR POST
        // ACTION, USER, PASS
        //Recoger parámetros
        //Ejemplo: PRODUCTO.ADD
        //actionReq: USUARIO.LOGIN
        String actionReq = (String) request.getParameter("ACTION");
        //el split rompe por un caracter de coincidencia
        //asi coge el punto como caracter
        //como si solo hubiera punto sin las barras
        String[] action = actionReq.split("\\.");
        // action[0] = USUARIO
        // action[1] = LOGIN
        Action miAction;
        String pageDestino = "";
        if (action[0].equals("USUARIO")) {
            miAction = new UsuarioAction(action[1]);
            pageDestino = miAction.execute(request, response);
        } else if (action[0].equals("LIBRO")) {
            miAction = new LibroAction(action[1]);
            pageDestino = miAction.execute(request, response);
        } 
        
        request.getRequestDispatcher(pageDestino).
                forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
