package OrientaObjetos;

public class Usuario {
    private String nombre;
    private char sexo;
    private String cargo;
    private int edad;
    private double salario;

    public Usuario(String nombre, char sexo, String cargo, int edad, double salario) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.cargo = cargo;
        this.edad = edad;
        this.salario = salario;
    }
    // Getters
    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }
    // Setters 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
