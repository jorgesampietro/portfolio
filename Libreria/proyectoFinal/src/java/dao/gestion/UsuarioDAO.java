package dao.gestion;

import java.sql.ResultSet;
import java.util.ArrayList;
import dao.orm.Usuario;
import dao.tools.SQLTools;
import dao.plantilla.DAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO extends SQLTools implements DAO<Usuario, Integer> {

    //                                          //
    //    Atributos                      //
    //                                         //
    private static final String SQL_INSERT
            = "INSERT INTO usuario (Tipo, User, Pass) "
            + "VALUES ";

    private static final String SQL_DELETE
            = "DELETE FROM usuario WHERE Id_usuario =";

    private static final String SQL_UPDATE
            = "UPDATE usuario SET ";

    private static final String SQL_FIND_ALL
            = "SELECT * FROM usuario";

    //                                                             //
    //    Metodos   a Implementar             //
    //                                                            //
    @Override
    public int add(Usuario entidad) throws Exception {
        super.conectar();                                                         // conecta a la base      

        String sql = SQL_INSERT + "( '" + entidad.getTipo() + "'," // crea la sentencia a ejecutar en la base de datos desde el atributo previamente creado como base
                + "'" + entidad.getUsuario()+ "', " // INSERT INTO tabla (Usuario, Tipo, Pass ) VALUES (' u ',  't ', 'p');
                + "'" + entidad.getPass() + "')";

        System.out.println("" + sql);
        int respuesta = super.ejecutar(sql);                                      // ejecuta la orden en el super. Es un numero por defecto en 0. Si hace cambios en la BD devuelve la cantidad de filas modificadas                                  
        super.desconectar();                                                      //al acabar desconecta de la base
        return respuesta;                                                         // devuelve el numero de filas que se han modificado

    }

    @Override
    public int delete(Integer id) throws Exception {
        super.conectar();

        String sql = SQL_DELETE + id;                                             // crea la sentencia a ejecutar en la base de datos desde el atributo previamente creado como base
        //  DELETE FROM tabla WHERE Id_usuario = id ";
        System.out.println("" + sql);
        int resp = super.ejecutar(sql);
        super.desconectar();
        return resp;
    }

    @Override
    public int update(Usuario entidad) throws Exception {
        super.conectar();

        String cabecera = SQL_UPDATE;                                             // crea la sentencia a ejecutar en la base de datos desde el atributo previamente creado como base
        String cuerpo = "";                                                         // UPDATE usuario SET + variable
        // con los if voy añadiendo a la variable las cosas a modificar o dejandolas como estan
       
         if (entidad.getTipo() != 0) {
            if (cuerpo.equals("")) {
                cuerpo += " TIPO=" + entidad.getTipo() + "";
            } else {
                cuerpo += ", TIPO=" + entidad.getTipo() + "";
            }
        }
         
        if (entidad.getUsuario() != null) {
            if (cuerpo.equals("")) {
                cuerpo += " USER='" + entidad.getUsuario() + "'";
            } else {
                cuerpo += ", USER='" + entidad.getUsuario() + "'";
            }
        }
       
        if (entidad.getPass() != null) {
            if (cuerpo.equals("")) {
                cuerpo += " PASS='" + entidad.getPass() + "'";
            } else {
                cuerpo += ", PASS='" + entidad.getPass() + "'";
            }
        }

        cuerpo += " WHERE ID_USUARIO=" + entidad.getIdUsuario();

        String sql;
        sql = cabecera + cuerpo;                                                    // lo junto todo para pasarlo con resp;

        System.out.println("" + sql);
        int resp = super.ejecutar(sql);
        super.desconectar();
        return resp;

    }

    @Override
    public boolean exists(Usuario entidad) throws Exception {
        boolean resp;
        super.conectar();
        String sql = "SELECT * FROM usuario WHERE USER='"
                + entidad.getUsuario()
                + "' AND PASS='"
                + entidad.getPass()
                + "' ";
        ResultSet rs = super.ejecutarConsulta(sql);
        if (rs.next()) {
            entidad.setIdUsuario(rs.getInt(1));
            entidad.setTipo(rs.getInt(2));
            resp = true;
        } else {
            resp = false;
        }

        System.out.println("" + sql);
        super.desconectar();
        return resp;

    }

    @Override
    public ArrayList<Usuario> findAll(Usuario entidad) throws Exception {
        super.conectar();
        String sql = SQL_FIND_ALL + getSQLDinamica(entidad);
        ResultSet rs = super.ejecutarConsulta(sql);
        ArrayList<Usuario> tabla = new ArrayList<Usuario>();
        while (rs.next()) {//si de la consulta solo se obtiene un registro no tiene siguiente
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt(1));
            usuario.setUsuario(rs.getString(3));
            usuario.setTipo(rs.getInt(2));
            usuario.setPass(rs.getString(4));
            tabla.add(usuario);
        }
        System.out.println("" + sql);
        super.desconectar();
        return tabla;

    }

    //                                                             //
    //    Metodos   especificos                   //
    //                                                            //
    private String getSQLDinamica(Usuario usuario) throws Exception {
// En el proyecto hemos llamado a CONSULTAS FIND (Buscar por cualqien parámetro del     
        String cuerpo = "";
        if (usuario != null) {
            if (usuario.getIdUsuario() != 0) {
                if (cuerpo.equals("")) {
                    cuerpo += " WHERE Id_usuario=" + usuario.getIdUsuario();
                } else {
                    cuerpo += " AND Id_usuario=" + usuario.getIdUsuario();
                }
            }
            if (usuario.getUsuario() != null) {
                if (cuerpo.equals("")) {
                    cuerpo += " WHERE User='" + usuario.getUsuario() + "'";
                } else {
                    cuerpo += " AND User='" + usuario.getUsuario() + "'";
                }
            }
            if (usuario.getTipo() != 0) {
                if (cuerpo.equals("")) {
                    cuerpo += " WHERE Tipo='" + usuario.getTipo() + "'";
                } else {
                    cuerpo += " AND Tipo='" + usuario.getTipo() + "'";
                }
            }
         
            if (usuario.getPass() != null) {
                if (cuerpo.equals("")) {
                    cuerpo += " WHERE Pass='" + usuario.getPass() + "'";
                } else {
                    cuerpo += " AND Pass='" + usuario.getPass() + "'";
                }
            }
        }
        return cuerpo;
    }

    //                                          //
    //    Pruebas Unitarias      //
    //                                         //
    public static void main(String[] args) {
        // PRUEBAS UNITARIAS

        //ORM
        Usuario usuario = new Usuario();
        usuario.setUsuario("pepe");
        usuario.setPass("1234");

        // Usuario DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.exists(usuario);
            System.out.println(usuario.getUsuario());

    //        usuario.setUsuario("CESAR");
    //        usuario.setTipo(121);
    //        usuario.setPass("123");
    //
    //        int respuesta;
    //
    //        try {
    //
    //            respuesta = usuarioDAO.add(usuario);
    //            if (respuesta > 0) {
    //                System.out.println("Test add correcto **********************");
    //            } else {
    //                System.out.println("Test add incorrecto");
    //            }
    //
    //            boolean resp = usuarioDAO.exists(usuario);
    //            if (resp) {
    //                System.out.println("Existe: " + usuario.toString());
    //            } else {
    //                System.out.println("El usuario es incorrecto ///////////////////// ");
    //            }
    //
    //            usuario.setUsuario("JUAN");
    //            usuario.setTipo(6);
    //            usuario.setPass("456");
    //
    //            respuesta = usuarioDAO.update(usuario);
    //            if (respuesta > 0) {
    //                System.out.println("Test update correcto   **********************");
    //            } else {
    //                System.out.println("Test update incorrecto /////////////////////");
    //            }
    //
    //            resp = usuarioDAO.exists(usuario);
    //            if (resp) {
    //                System.out.println("Existe: " + usuario.toString());
    //            } else {
    //                System.out.println("El usuario es incorrecto /////////////////////");
    //            }
    //
    //            respuesta = usuarioDAO.delete(usuario.getIdUsuario());
    //            if (respuesta > 0) {
    //                System.out.println("Test delete correcto  **********************");
    //            } else {
    //                System.out.println("Test delete incorrecto /////////////////////");
    //            }
    //
    //        } catch (Exception ex) {
    //                System.out.println("algo va mal");
    //        }
    //
    //        try {
    //            Usuario usuario1 = null;
    //            ArrayList<Usuario> tabla = usuarioDAO.findAll(usuario1);
    //            for (Usuario listaUsuario : tabla) {
    //                System.out.println(listaUsuario.toString());
    //            }
    //            System.out.println("Test listado correcto   **********************");
    //            ArrayList<Usuario> consulta = usuarioDAO.findAll(usuario);
    //            for (Usuario listaUsuario : consulta) {
    //                System.out.println("soy usuario");
    //                System.out.println(listaUsuario.toString());
    //            }
    //        } catch (Exception ex) {
    //            System.out.println("Error en usuarioDAO  /////////////////////");
    //        }
    //    }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
}
