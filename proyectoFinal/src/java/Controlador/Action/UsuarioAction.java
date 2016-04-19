package Controlador.Action;

import dao.gestion.UsuarioDAO;
import dao.orm.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsuarioAction implements Action {

    private String method = "";

    public UsuarioAction(String method) {
        this.method = method; // "LOGIN"
    }

    @Override
    public String execute(HttpServletRequest request,
            HttpServletResponse response) {
        String pageResp = "";

        if (method.equals("LOGIN")) {
            pageResp = login(request, response);
        } else if (method.equals("ADD")) {
            pageResp = add(request, response);
        } else if (method.equals("FIND")) {
        } else if (method.equals("FIND_ALL")) {
//            pageResp = listar(request, response);
        } else if (method.equals("DELETE")) {
        } else if (method.equals("UPDATE")) {
        } else if (method.equals("logout")) {
            try {
                pageResp = logout(request, response);
            } catch (Exception ex) {
                System.out.println("error al desconectar");
            }
        }
        return pageResp;
    }

    private String login(HttpServletRequest request,
            HttpServletResponse response) {
        String pageResp = "";
        String user = (String) request.getParameter("USER");
        //accedemos a traves de la clave USER
        String pass = (String) request.getParameter("PASS");

        UsuarioDAO clienteDAO = new UsuarioDAO();
        Usuario miCliente = new Usuario(user, pass);

        boolean resp = false;
        try {//intenta hacer esto porque vamos a hacer una peticion externa al programa y puede haber algun error
            resp = clienteDAO.exists(miCliente);
        } catch (Exception ex) {
        }
        //en el caso de que dé algún error ....
        if (resp) {
//                HttpSession sesion = request.getSession();
            if (miCliente.getTipo() == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("Objeto usuario", miCliente);
                session.setAttribute("USUARIO", miCliente);
                session.setAttribute("MENSAJE", "Bienvenido "
                        + miCliente.getUsuario());
                session.setAttribute("RESP", "true");
                pageResp = "pageAdmin.jsp";
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("Objeto usuario", miCliente);
                session.setAttribute("USUARIO", miCliente);
                session.setAttribute("MENSAJE", "Bienvenido "
                        + miCliente.getUsuario());
                session.setAttribute("RESP", "true");
                pageResp = "index.jsp";
            }
        } else {

            HttpSession session = request.getSession();
            session.setAttribute("Objeto usuario", miCliente);
            session.setAttribute("USUARIO", miCliente);
            session.setAttribute("RESP", "false");
            
            
            pageResp = "index.jsp";



        }
        return pageResp;
    }

    private String add(HttpServletRequest request,
            HttpServletResponse response) {
        String pageResp = "";
        String user = (String) request.getParameter("USER");
        String pass = (String) request.getParameter("PASS");
        String tipo = (String) request.getParameter("TIPO");
        Integer numeroTipo = Integer.parseInt(tipo);

        UsuarioDAO clienteDAO = new UsuarioDAO();
        Usuario miCliente = new Usuario(numeroTipo, user, pass);
        try {
            int resp = clienteDAO.add(miCliente);
            if (resp != 0) {
                System.out.println("El usuario se ha añadido correctamente***");
                request.setAttribute("USUARIO", miCliente);
                request.setAttribute("MENSAJE", "Se ha creado "
                        + miCliente.getUsuario());
                pageResp = "crearUsuario.jsp";
            }
        } catch (Exception ex) {
            System.out.println("error al anadir");
        }

        return pageResp;
    }

    private String logout(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("Objeto usuario");
            session.invalidate();
        }

        return "index.jsp";

    }
}
