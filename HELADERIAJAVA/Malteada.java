import java.util.ArrayList;

public class Malteada {
    public int id;
    public float precio;
    private float precioTopping;
    private ArrayList<String> sabores;
    private ArrayList<String> toppings;
    private int tipo;

    // Constructor igual que Helado
    public Malteada(int id, float precio, ArrayList<String> sabores, int tipo) {
        this.id = id;
        this.precio = precio;
        this.sabores = sabores;
        this.tipo = tipo;
        this.toppings = new ArrayList<>();
        this.precioTopping = 500; // mismo valor que Helado
    }

    // Métodos
    public float calcularPrecio() {
        return this.precio + (this.toppings.size() * this.precioTopping);
    }

    // Setters
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setSabores(ArrayList<String> sabores) {
        this.sabores = sabores;
    }

    public void addTopping(String toppingType) {
        this.toppings.add(toppingType);
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    // Getters
    public float getPrecio() {
        return precio;
    }

    public ArrayList<String> getSabores() {
        return sabores;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public int getTipo() {
        return tipo;
    }

    public float getPrecioTopping() {
        return this.precioTopping;
    }

    public String toString() {
        return "Malteada [sabores=" + sabores + ", precio=" + precio + "]";
    }
}
