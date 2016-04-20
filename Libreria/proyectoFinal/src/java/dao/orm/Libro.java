
package dao.orm;

public class Libro {

    // Atributos de la clase
    private int id_libro;
    private int isbn;
    private String titulo;
    private String autor;
    private int cantidad;
    private int precio;

    // constructores
    public Libro(int isbn, String titulo, String autor, int cantidad, int precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Libro() {
    }

    public Libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    //

    // getter and setter
    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    //toString
    @Override
    public String toString() {
        return "Libro{" + "id_libro=" + id_libro 
                + ", isbn=" + isbn 
                + ", titulo=" + titulo 
                + ", autor=" + autor 
                + ", cantidad=" + cantidad 
                + ", precio=" + precio + '}';
    }
    
    

}// FIN
