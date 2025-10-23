package DiagramaTarea;
// ------------------------
// Clase Lector (hija de Usuario)
// ------------------------
class Lector extends Usuario {
    private String tipoLector; // estudiante, profesor, etc.

    public Lector(String idUsuario, String nombre, String telefono, String tipoLector) {
        super(idUsuario, nombre, telefono);
        this.tipoLector = tipoLector;
    }

    public String getTipoLector() {
        return tipoLector;
    }
}
