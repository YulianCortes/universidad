package DiagramaTarea;
// ------------------------
// Clase Prestamo
// ------------------------
import java.time.LocalDate;

public class Prestamo {
    private String idPrestamo;
    private Lector lector;
    private Ejemplar ejemplar;
    private Bibliotecario bibliotecario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean activo;

    public Prestamo(String idPrestamo, Lector lector, Ejemplar ejemplar, Bibliotecario bibliotecario, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idPrestamo = idPrestamo;
        this.lector = lector;
        this.ejemplar = ejemplar;
        this.bibliotecario = bibliotecario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activo = true;
        ejemplar.prestar();
    }

    public void devolver() {
        ejemplar.devolver();
        activo = false;
    }
}
