package dao.orm;

public class Usuario {
    /*
     *  Textos completos 	
     * Id_usuario 	  	
     * Tipo
     * Usuario
     * Pass 
     */
    // Atributos de la clase
    private  int idUsuario;
    private int tipo;
    private String usuario;
    private String pass;

    // constructores 
    
    public Usuario() {
    }

    public Usuario(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
        
    }
    public Usuario(int tipo, String usuario, String pass) {
        this.tipo = tipo;
        this.usuario = usuario;
        this.pass = pass;
    }

    // getter and setter
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario 
                + ", tipo=" + tipo 
                + ", usuario=" + usuario 
                + ", pass=" + pass + '}';
    }
    
    

}
