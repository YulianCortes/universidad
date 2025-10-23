package DiagramaTarea;
// ------------------------
// Clase Libro
// ------------------------
import java.util.*;

public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;
    private List<Ejemplar> ejemplares;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
        this.ejemplares = new ArrayList<>();
    }

    public void agregarEjemplar(Ejemplar ejemplar) {
        ejemplares.add(ejemplar);
    }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return titulo + " de " + autor;
    }
}
