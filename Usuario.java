public class Usuario{
    private String nombre;
    private float salario;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;// this se refiere a la instancia actual de la clase Usuario
        this.salario = salario;
    }
// el getter y setter son metodos que permiten acceder y modificar los atributos privados de la clase
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
}