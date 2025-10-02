package HELADERIA;
import java.util.ArrayList;

public class Malteada {
    public int id;
    public float precio;
    private float precioTopping;
    private ArrayList<String> sabores;
    private ArrayList<String> toppings;

    // Constructor de clase
    public Malteada(int id, float precio, ArrayList<String> sabores){
        this.id = id;
        this.precio = precio;
        this.sabores = sabores;
        this.toppings = new ArrayList<String>();
        this.precioTopping = 500; // mismo valor que en Helado por defecto
    }

    // Metodos de clase
    public float calcularPrecio(){
        float precioTotal = this.precio + (this.precioTopping * this.toppings.size());
        return precioTotal;
    }

    // Setters
    public void setPrecio(float precio){
        this.precio = precio;
    }

    public void setPrecioTopping(float precioTopping){
        this.precioTopping = precioTopping;
    }

    public void setSabores(ArrayList<String> sabores){
        this.sabores = sabores;
    }

    public void addTopping(String toppingType){
        this.toppings.add(toppingType);
    }

    // Getters
    public float getPrecio(){
        return this.precio;
    }

    public ArrayList<String> getSabores(){
        return this.sabores;
    }

    public ArrayList<String> getToppings(){
        return this.toppings;
    }

    public float getPrecioTopping(){
        return this.precioTopping;
    }
}
