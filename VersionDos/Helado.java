package VersionDos; // Paquete donde está nuestro código
// Clase que representa un helado con todas sus características
public class Helado {
    // Atributos de la clase
    private String tipo;        // Tipo de helado (Cono, Copa, Ensalada, etc.)
    private String sabor;       // Sabor del helado (Maracuyá, Vainilla, etc.)
    private String acompanante; // Acompañante (Galleta, Gomita, Chips, etc.)
    private String pago;        // Método de pago (Efectivo, Virtual, etc.)

    // Constructor: sirve para crear un objeto Helado con todos los atributos
    public Helado(String tipo, String sabor, String acompanante, String pago) {
        this.tipo = tipo;
        this.sabor = sabor;
        this.acompanante = acompanante;
        this.pago = pago;
    }

    // Sobrescribimos el método toString() para mostrar el helado como texto
    @Override
    public String toString() {
        return "Helado{" +
                "tipo='" + tipo + '\'' +
                ", sabor='" + sabor + '\'' +
                ", acompañante='" + acompanante + '\'' +
                ", pago='" + pago + '\'' +
                '}';
    }

    // Métodos getters (nos permiten leer los atributos si los necesitamos en otra clase)
    public String getTipo() { return tipo; }
    public String getSabor() { return sabor; }
    public String getAcompanante() { return acompanante; }
    public String getPago() { return pago; }
}