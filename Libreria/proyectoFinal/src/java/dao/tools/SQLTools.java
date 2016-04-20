package dao.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SQLTools {
    // ATRIBUTOS
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private static final String URL = "jdbc:mysql://localhost:3306/libreria";
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
	
    // MÉTODOS
    public void conectar(){
        try {
            // Indico el controlador necesario en función de la base de datos
            Class.forName(CONTROLADOR);
            // Objeto que me devuelve una conexión a MySql
            con = DriverManager.getConnection(URL,USER,PASS);
            // Un objeto que me permite interactuar con la base de datos
            st = con.createStatement();
        }catch (Exception ex) {
            System.out.println("Error al conectar a la base de datos.");
        }
    }
    public void desconectar(){
        try {
            // ResultSet
            if(rs!=null){ rs.close();}
            // Statement
            if(st!=null){ st.close();}
            // Connection
            if(con!=null){ con.close();}
        } catch (Exception ex) {
            System.out.println("Error al cerrar la conexión. ");
        }
    }
    public int ejecutar(String sql){ 
        //INSERT INTO CLIENTE(USER,PASS) VALUES ('LUIS','1234')
        int resp = 0 ;
        try {
            resp = st.executeUpdate(sql);
            // el de arriba ó este => resp = st.execute(sql) los dos estan bien;
        } catch (Exception ex) {
            System.out.println("Error al modificar los datos. ");
        }
return resp;
    }
    public ResultSet ejecutarConsulta(String sql){ // SELECT * FROM CLIENTE
       try {
            rs = st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error al consultar los datos. ");
        }
return rs;
   }
}
