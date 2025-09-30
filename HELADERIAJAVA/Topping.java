public class Topping {
    private String nombre;
    private double precio;

    // Constructor público
    public Topping(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Constantes predefinidas (opcionales, por si las quieres usar)
    public static final Topping CHIPS = new Topping("Chips", 500.0);
    public static final Topping GALLETAS = new Topping("Galletas", 500.0);
    public static final Topping GOMITAS = new Topping("Gomitas", 500.0);

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}
