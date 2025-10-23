package DiagramaTarea;
// ------------------------
// Clase Ejemplar
// ------------------------
public class Ejemplar {
    private String codigo;
    private boolean disponible;
    private Libro libro;

    public Ejemplar(String codigo, Libro libro) {
        this.codigo = codigo;
        this.libro = libro;
        this.disponible = true;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getCodigo() {
        return codigo;
    }
}
