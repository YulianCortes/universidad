package DiagramaTarea;
// ------------------------
// Clase Usuario (padre)
// ------------------------
public class Usuario {
    protected String id;
    protected String nombre;
    protected String telefono;

    public Usuario(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
}
