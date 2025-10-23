package DiagramaTarea;
// ------------------------
// Clase Bibliotecario (hija de Usuario)
// ------------------------
public class Bibliotecario extends Usuario {
    private String turno;

    public Bibliotecario(String id, String nombre, String telefono, String turno) {
        super(id, nombre, telefono);
        this.turno = turno;
    }
}
