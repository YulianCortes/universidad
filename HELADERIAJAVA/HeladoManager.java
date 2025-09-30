import java.util.ArrayList;

public class HeladoManager {
    private ArrayList<Helado> helados = new ArrayList<>();

    public void agregarHelado(Helado h) {
        helados.add(h);
    }

    public void mostrarHelados() {
        System.out.println("\n--- Helados disponibles ---");
        for (int i = 0; i < helados.size(); i++) {
            Helado h = helados.get(i);
            String tipo = switch (h.getTipo()) {
                case 1 -> "Cono";
                case 2 -> "Canasta";
                case 3 -> "Vaso";
                default -> "Desconocido";
            };
            System.out.println(
                i + ". Sabores: " + h.getSabores() +
                " | Tipo: " + tipo +
                " | Precio: " + h.getPrecio()
            );
        }
    }

    public Helado obtenerHelado(int indice) {
        if (indice >= 0 && indice < helados.size()) {
            return helados.get(indice);
        }
        return null;
    }
}
