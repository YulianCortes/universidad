package DiagramaTarea;
// ------------------------
// Clase Main (para probar el sistema)
// ------------------------
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Calle 123");

        // Crear libro y ejemplares
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez");
        Ejemplar ej1 = new Ejemplar("EJ001", libro1);
        Ejemplar ej2 = new Ejemplar("EJ002", libro1);
        libro1.agregarEjemplar(ej1);
        libro1.agregarEjemplar(ej2);
        biblioteca.agregarLibro(libro1);

        // Crear usuarios
        Lector lector1 = new Lector("U001", "María López", "555-1234", "estudiante");
        Bibliotecario biblio1 = new Bibliotecario("B001", "Carlos Pérez", "555-5678", "mañana");
        biblioteca.registrarUsuario(lector1);

        // Crear préstamo
        Prestamo prestamo1 = new Prestamo(
            "P001",
            lector1,
            ej1,
            biblio1,
            LocalDate.now(),
            LocalDate.now().plusDays(7)
        );
        biblioteca.registrarPrestamo(prestamo1);

        System.out.println("Préstamo creado para " + lector1.getNombre() + 
                           " del libro " + libro1.getTitulo() + ".");
    }
}
