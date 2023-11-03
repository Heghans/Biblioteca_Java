package Objetos;
import java.io.Serializable;

/**
 * La clase Libros representa un libro y sus atributos, incluyendo título, autor, género, año de publicación,
 * ISBN y su estado de préstamo.
 */
public class Libros implements Serializable {
    private String titulo;
    private String autor;
    private String genero;
    private int ans;
    private int isbn;

    private boolean prestado;
    private int cedulaUsuarioPrestado;

    /**
     * Constructor para crear un objeto Libros.
     *
     * @param titulo              El título del libro.
     * @param autor               El autor del libro.
     * @param genero              El género del libro.
     * @param ans                 El año de publicación del libro.
     * @param isbn                El número ISBN del libro.
     * @param prestado            El estado de préstamo del libro (true si está prestado, false si no lo está).
     */
    public Libros(String titulo, String autor, String genero, int ans, int isbn, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ans = ans;
        this.isbn = isbn;
        this.prestado = prestado;
        this.cedulaUsuarioPrestado = 0;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene el género del libro.
     *
     * @return El género del libro.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Obtiene el año de publicación del libro.
     *
     * @return El año de publicación del libro.
     */
    public int getAns() {
        return ans;
    }

    /**
     * Obtiene el número ISBN del libro.
     *
     * @return El número ISBN del libro.
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * Obtiene la cédula del usuario que tiene el libro prestado.
     *
     * @return La cédula del usuario que tiene el libro prestado.
     */
    public int getCedulaUsuarioPrestado() {
        return cedulaUsuarioPrestado;
    }

    /**
     * Marca el libro como prestado.
     */
    public void setPrestado(boolean b) {
        this.prestado = true;
    }

    /**
     * Verifica si el libro está prestado.
     *
     * @return true si el libro está prestado, false si no lo está.
     */
    public boolean getPrestado(boolean b) {
        return prestado;
    }

    /**
     * Verifica si el libro está prestado.
     *
     * @return true si el libro está prestado, false si no lo está.
     */
    public boolean isPrestado() {
        return prestado;
    }

    /**
     * Marca el libro como prestado por un usuario con la cédula especificada.
     *
     * @param cedulaUsuario La cédula del usuario que toma prestado el libro.
     */
    public void prestar(int cedulaUsuario) {
        prestado = true;
        cedulaUsuarioPrestado = cedulaUsuario;
    }

    /**
     * Marca el libro como prestado por un usuario con la cédula especificada.
     *
     * @param cedulaUsuario La cédula del usuario que toma prestado el libro.
     */
    public void tomarPrestado(int cedulaUsuario) {
        if (!prestado) {
            prestado = true;
            cedulaUsuarioPrestado = cedulaUsuario;
        }
    }

    /**
     * Marca el libro como devuelto.
     */
    public void devolver() {
        if (prestado) {
            prestado = false;
            cedulaUsuarioPrestado = 0;
        }
    }

    /**
     * Obtiene una representación en forma de cadena del libro, incluyendo título, autor, género, año de publicación,
     * ISBN y estado de préstamo.
     *
     * @return Una cadena que representa el libro.
     */
    @Override
    public String toString() {
        return "Libro: " + titulo +
                "\nAutor: " + autor +
                "\nGénero: " + genero +
                "\nAño de publicación: " + ans +
                "\nISBN: " + isbn +
                "\nCondición de prestado: " + prestado;
    }
}