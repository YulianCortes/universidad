import java.util.ArrayList;

public class ToppingManager {
    private ArrayList<Topping> toppings = new ArrayList<>();

    public void agregarTopping(Topping t) {
        toppings.add(t);
    }

    public void mostrarToppings() {
        System.out.println("\n--- Toppings disponibles ---");
        for (int i = 0; i < toppings.size(); i++) {
            Topping t = toppings.get(i);
            System.out.println(i + ". " + t.getNombre() + " | Precio: " + t.getPrecio());
        }
    }

    public Topping getToppingPorIndice(int indice) {
        if (indice >= 0 && indice < toppings.size()) {
            return toppings.get(indice);
        }
        return null;
    }
}
