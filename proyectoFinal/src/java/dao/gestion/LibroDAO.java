/* productos
 1. Id_producto                                         int(11)	  	NO 
 //2. Cod                                                varchar(45)	NO	  	 
 3. Nombre                                                varchar(45)	NO	  	 
 * 4. Precio                                                  double(10,2)	No 
 * 5. Cantidad                                              int(11)                        No 	  	 
 
 */
package dao.gestion;

import java.sql.ResultSet;
import java.util.ArrayList;
import dao.orm.Libro;
import dao.tools.SQLTools;
import dao.plantilla.DAO;

public class LibroDAO extends SQLTools implements DAO<Libro, Integer> {

    //                                          //
    //    Atributos                      //*******************************************
    //                                         //
    private static final String SQL_INSERT = "INSERT INTO libro (isbn, titulo, autor, cantidad, precio) "
            + "VALUES ";
    private static final String SQL_DELETE = "DELETE FROM libro WHERE Id_libro = ";
    private static final String SQL_UPDATE = "UPDATE libro SET ";
    private static final String SQL_FIND_ALL = "SELECT * FROM libro";

    //                                                             //
    //    Metodos   a Implementar             //*******************************************
    //                                                            //
    @Override
    public int add(Libro entidad) throws Exception {
        super.conectar();                                                           // conecta a la base      

        String sql = SQL_INSERT + "('" + entidad.getIsbn() + "'," // crea la sentencia a ejecutar en la base de datos desde el atributo previamente creado como base
                + "'" + entidad.getTitulo() + "', "
                + "'" + entidad.getAutor() + "', "
                + "'" + entidad.getCantidad() + "', "
                + "'" + entidad.getPrecio() + "')";


        System.out.println("" + sql);
        int respuesta = super.ejecutar(sql);                                        // ejecuta la orden en el super. Es un numero por defecto en 0. Si hace cambios en la BD devuelve la cantidad de filas modificadas                                  
        super.desconectar();                                                        // al acabar desconecta de la base
        return respuesta;                                                           // devuelve el numero de filas que se han modificado

    }

    @Override
    public int delete(Integer id_Libro) throws Exception {
        super.conectar();

        String sql = SQL_DELETE + id_Libro;                                      // crea la sentencia a ejecutar en la base de datos desde el atributo previamente creado como base

        System.out.println("" + sql);
        int resp = super.ejecutar(sql);
        super.desconectar();
        return resp;
    }

    @Override
    public int update(Libro entidad) throws Exception {
        super.conectar();

        String cabecera = SQL_UPDATE;                                               // crea la sentencia a ejecutar en la base de datos desde el atributo previamente creado como base
        String cuerpo = "";                                                         // UPDATE producto SET + variable

        if (entidad.getIsbn() != 0) {                                          // con los if voy añadiendo a la variable las cosas a modificar o dejandolas como estan
            if (cuerpo.equals("")) {
                cuerpo += " isbn = " + entidad.getIsbn() ;
            } else {
                cuerpo += ", isbn = " + entidad.getIsbn() ;
            }
        }
        if (entidad.getTitulo() != null) {
            if (cuerpo.equals("")) {
                cuerpo += " titulo = '" + entidad.getTitulo() + "'";
            } else {
                cuerpo += ", titulo = '" + entidad.getTitulo() + "'";
            }
        }
        if (entidad.getAutor() != null) {
            if (cuerpo.equals("")) {
                cuerpo += " autor = '" + entidad.getAutor() + "'";
            } else {
                cuerpo += ", autor = '" + entidad.getAutor() + "'";
            }
        }
        if (entidad.getPrecio() != 0) {
            if (cuerpo.equals("")) {
                cuerpo += " precio = " + entidad.getPrecio() ;
            } else {
                cuerpo += ", precio = " + entidad.getPrecio() ;
            }
        }
        if (entidad.getCantidad() != 0) {
            if (cuerpo.equals("")) {
                cuerpo += " cantidad = " + entidad.getCantidad() ;
            } else {
                cuerpo += ", cantidad = " + entidad.getCantidad();
            }
        }

        cuerpo += " WHERE id_libro = " + entidad.getId_libro();

        String sql;
        sql = cabecera + cuerpo;                                                    // lo junto todo para pasarlo con resp;

        System.out.println("" + sql);
        int resp = super.ejecutar(sql);
        super.desconectar();
        return resp;
    }

    @Override
    public boolean exists(Libro entidad) throws Exception {
        boolean resp;
        super.conectar();
        String sql = "SELECT * FROM libro WHERE titulo = '"
                + entidad.getTitulo()
                + "'";
        ResultSet rs = super.ejecutarConsulta(sql);
        if (rs.next()) {
            entidad.setId_libro(rs.getInt(1));
            entidad.setIsbn(rs.getInt(2));
            entidad.setAutor(rs.getString(4));
            entidad.setCantidad(rs.getInt(5));
            entidad.setPrecio(rs.getInt(6));
            resp = true;
        } else {
            resp = false;
        }

        System.out.println("" + sql);
        super.desconectar();
        return resp;

    }

    @Override
    public ArrayList<Libro> findAll(Libro entidad) throws Exception {
        super.conectar();
        String sql = SQL_FIND_ALL + getSQLDinamica(entidad);
        ResultSet rs = super.ejecutarConsulta(sql);
        ArrayList<Libro> tabla = new ArrayList<Libro>();
        while (rs.next()) {
            Libro producto = new Libro();
            producto.setId_libro(rs.getInt(1));
            producto.setIsbn(rs.getInt(2));
            producto.setTitulo(rs.getString(3));
            producto.setAutor(rs.getString(4));
            producto.setCantidad(rs.getInt(5));
            producto.setPrecio(rs.getInt(6));
            tabla.add(producto);
        }
        System.out.println("" + sql);
        super.desconectar();
        return tabla;
    }

    //                                                             //
    //    Metodos   especificos                   //*******************************************
    //                                                            //
    private String getSQLDinamica(Libro producto) throws Exception {
// En el proyecto hemos llamado a CONSULTAS FIND (Buscar por cualqien parámetro del     
        String cuerpo = "";
        if (producto != null) {
            if (producto.getId_libro() != 0) {
                if (cuerpo.equals("")) {
                    cuerpo += " WHERE id_libro = " + producto.getId_libro();
                } else {
                    cuerpo += " AND id_libro = " + producto.getId_libro();
                }
            }
            if (producto.getIsbn() != 0) {
                if (cuerpo.equals("")) {
                    cuerpo += " WHERE isbn = " + producto.getIsbn();
                } else {
                    cuerpo += " AND isbn = " + producto.getIsbn();
                }
            }
            if (producto.getTitulo() != null) {
                if (cuerpo.equals("")) {
                    cuerpo += " WHERE titulo LIKE '%" + producto.getTitulo() + "%'";
                } else {
                    cuerpo += " AND titulo LIKE '%" + producto.getTitulo() + "%'";
                }
            }
            if (producto.getAutor()!= null) {
                if (cuerpo.equals("")) {
                    cuerpo += " WHERE autor LIKE '%" + producto.getAutor()+ "%'";
                } else {
                    cuerpo += " AND autor LIKE '%" + producto.getAutor()+ "%'";
                }
            }
            if (producto.getPrecio() != 0) {
                if (cuerpo.equals("")) {
                    cuerpo += " WHERE precio = " + producto.getPrecio();
                } else {
                    cuerpo += " AND precio = " + producto.getPrecio();
                }
            }
            if (producto.getCantidad()!= 0) {
                if (cuerpo.equals("")) {
                    cuerpo += " WHERE cantidad = " + producto.getCantidad();
                } else {
                    cuerpo += " AND cantidad = " + producto.getCantidad();
                }
            }
        }
        return cuerpo;
    }

    //                                          //
    //    Pruebas Unitarias      //*******************************************
    //                                         //
    public static void main(String[] args) {
        // PRUEBAS UNITARIAS

        // ORM
        Libro producto = new Libro();

        // Cliente DAO
        LibroDAO productoDAO = new LibroDAO();

        producto.setIsbn(001);
        producto.setTitulo("HARRY POTTER");
        producto.setAutor("J.K Rowling");
        producto.setCantidad(10);
        producto.setPrecio(2);

        int respuesta;

        try {

            respuesta = productoDAO.add(producto);
            if (respuesta > 0) {
                System.out.println("Test add correcto   **********************");
            } else {
                System.out.println("Test add incorrecto /////////////////////");
            }

            boolean resp = productoDAO.exists(producto);
            if (resp) {
                System.out.println("Existe" + producto.toString());
                System.out.println("Test exist correcto   **********************");
            } else {
                System.out.println("El PRODUCTO es incorrecto /////////////////////");
            }

            producto.setTitulo("El senior de los anillos");
            producto.setAutor("J.R Tolkien");
            producto.setCantidad(25);
            producto.setPrecio(4);

            respuesta = productoDAO.update(producto);
            if (respuesta > 0) {
                System.out.println("Test update correcto   **********************");
            } else {
                System.out.println("Test update incorrecto /////////////////////");
            }

            resp = productoDAO.exists(producto);
            if (resp) {
                System.out.println("Existe" + producto.toString());
                System.out.println("Test exist correcto   **********************");
            } else {
                System.out.println("El PRODUCTO es incorrecto /////////////////////");
            }

            respuesta = productoDAO.delete(producto.getId_libro());
            if (respuesta > 0) {
                System.out.println("Test delete correcto   **********************");
            } else {
                System.out.println("Test delete incorrecto /////////////////////");
            }

        } catch (Exception ex) {
        }

        try {
            Libro producto1 = null;
            ArrayList<Libro> tabla = productoDAO.findAll(producto1);
            for (Libro listaLibro : tabla) {
                System.out.println(listaLibro.toString());
            }
            Libro producto2 = new Libro();
            producto2.setTitulo("Diamond");
            System.out.println("Test listado correcto   **********************");
            ArrayList<Libro> consulta = productoDAO.findAll(producto2);
            for (Libro listaLibro : consulta) {//Cuando solo imprime un producto no entra
                System.out.println(listaLibro.toString());
            }
        } catch (Exception ex) {
            System.out.println("Test listado incorrecto /////////////////////");
        }
    }
}// fin
