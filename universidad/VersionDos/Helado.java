package VersionDos; // Paquete donde está nuestro código
// Clase que representa un helado con todas sus características
public class Helado {
    private String cliente;     // Nombre del cliente
    private String tipo;        // Tipo de helado
    private String sabor;       // Sabor del helado
    private String acompanante; // Acompañante
    private String pago;        // Método de pago
    // Constructor
    public Helado(String cliente, String tipo, String sabor, String acompanante, String pago) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.sabor = sabor;
        this.acompanante = acompanante;
        this.pago = pago;
    }
    // toString para mostrar bonito el pedido
    public String toString() {
        return "Cliente: " + cliente +
                " | Tipo: " + tipo +
                " | Sabor: " + sabor +
                " | Acompañante: " + acompanante +
                " | Pago: " + pago;
    }
    // Getters
    public String getCliente() { return cliente; }
    public String getTipo() { return tipo; }
    public String getSabor() { return sabor; }
    public String getAcompanante() { return acompanante; }
    public String getPago() { return pago; }
}