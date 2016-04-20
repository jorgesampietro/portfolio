package Controlador.Action;

import dao.gestion.LibroDAO;
import dao.orm.Libro;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LibroAction implements Action {

    private String method = "";

    public LibroAction(String method) {
        this.method = method; // "LOGIN"
    }

    @Override
    public String execute(HttpServletRequest request,
            HttpServletResponse response) {
        String pageResp = "";


        if (method.equals("ADD")) {
            pageResp = add(request, response);

        } else if (method.equals("FIND")) {
            try {
                pageResp = find(request, response);
            } catch (Exception ex) {
                System.out.println("error al buscar un libro");
            }
        } else if (method.equals("FIND_ALL")) {
            try {
                pageResp = listar(request, response);

            } catch (Exception ex) {
                System.out.println("error al listar");
            }
        } else if (method.equals("DELETE")) {
            try {
                pageResp = delete(request, response);
            } catch (Exception ex) {
                System.out.println("error al borrar");
            }
        } else if (method.equals("UPDATE")) {
            try {
                pageResp = modificar(request, response);
            } catch (Exception ex) {
                System.out.println("error al actualizar");
            }
        }
        return pageResp;
    }


    private String add(HttpServletRequest request,
            HttpServletResponse response) {
        String pageResp = "";
        String isbn = (String) request.getParameter("ISBN");
        String titulo = (String) request.getParameter("TITULO");
        String autor = (String) request.getParameter("AUTOR");
        String cantidad = (String) request.getParameter("CANTIDAD");
        String precio = (String) request.getParameter("PRECIO");

        Integer isbnLibro = Integer.parseInt(isbn);
        Integer cantidadLibro = Integer.parseInt(cantidad);
        Integer precioLibro = Integer.parseInt(precio);

        LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro(isbnLibro, titulo, autor, cantidadLibro, precioLibro);
        try {
            int resp = libroDAO.add(libro);
            if (resp != 0) {
                System.out.println("El libro se ha añadido correctamente***");
                request.setAttribute("PRODUCTO", libro);
                request.setAttribute("MENSAJE", libro.getTitulo()
                        + " se ha añadido correctamente");
                pageResp = "anadirLibro.jsp";
            }
        } catch (Exception ex) {
            System.out.println("error al anadir un libro");
        }

        return pageResp;
    }

    private String delete(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String pageResp = "";
        String idLibro = request.getParameter("IDLIBRO");
        int idConverse = Integer.parseInt(idLibro);
        LibroDAO libroDAO = new LibroDAO();
        int resp = 0;
        try {
            resp = libroDAO.delete(idConverse);
        } catch (Exception ex) {
            System.out.println("error al borrar");
        }

        if (resp != 0) {
            request.setAttribute("NUMERO", "1");
            request.setAttribute("MENSAJE", "El libro con ID " + idConverse
                    + " se ha borrado correctamente");
        }
        pageResp = "listar.jsp";
        pageResp = listar(request, response);
        return pageResp;
    }

    private String listar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String pageResp = "";
        Libro libro = new Libro();
        LibroDAO libroDAO = new LibroDAO();
        ArrayList<Libro> misLibros = new ArrayList<Libro>();
        misLibros = libroDAO.findAll(libro);

        if (misLibros.size() >= 1) {
            HttpSession session = request.getSession();
            session.setAttribute("lista", misLibros);
        }
        pageResp = "listar.jsp";
        return pageResp;
    }

    private String find(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String pageResp = "";
        String isbn = (String) request.getParameter("ISBN");
        String titulo = (String) request.getParameter("TITULO");
        String autor = (String) request.getParameter("AUTOR");
        String cantidad = (String) request.getParameter("CANTIDAD");
        String precio = (String) request.getParameter("PRECIO");

        LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro();

        if (isbn != "") {
            Integer isbnLibro = Integer.parseInt(isbn);
            libro.setIsbn(isbnLibro);
        }
        if (titulo != "") {
            libro.setTitulo(titulo);
        }
        if (autor != "") {
            libro.setAutor(autor);
        }
        if (cantidad != "") {
            Integer cantidadLibro = Integer.parseInt(cantidad);
            libro.setCantidad(cantidadLibro);
        }
        if (precio != "") {
            Integer precioLibro = Integer.parseInt(precio);
            libro.setPrecio(precioLibro);
        }

        ArrayList<Libro> misLibros = new ArrayList<Libro>();
        misLibros = libroDAO.findAll(libro);
        if (misLibros.size() >= 1) {
            HttpSession session = request.getSession();
            session.setAttribute("lista", misLibros);
        } else {
            request.setAttribute("PRODUCTO", libro);
            request.setAttribute("MENSAJE", "El libro no existe");

        }

        pageResp = "buscar.jsp";
        return pageResp;
    }

    private String modificar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String pageResp = "";
        String id_libro = request.getParameter("modificarIDlibro");
        String isbn = request.getParameter("modificarISBN");
        String titulo = request.getParameter("modificarTitulo");
        String autor = request.getParameter("modificarAutor");
        String cantidad = request.getParameter("modificarCantidad");
        String precio = request.getParameter("modificarPrecio");

        int idLibro = Integer.parseInt(id_libro);
        int isbnLibro = Integer.parseInt(isbn);
        int cantidadLibro = Integer.parseInt(cantidad);
        int precioLibro = Integer.parseInt(precio);

        LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro(isbnLibro, titulo, autor, cantidadLibro, precioLibro);
        libro.setId_libro(idLibro);
        int Resp = libroDAO.update(libro);
        if (Resp != 0) {

            request.setAttribute("PRODUCTO", libro);
            request.setAttribute("MENSAJE", "El libro con id " + libro.getId_libro()
                    + " se ha actualizado correctamente");
            pageResp = listar(request, response);
        }
        pageResp = "listar.jsp";
        return pageResp;

    }
}
