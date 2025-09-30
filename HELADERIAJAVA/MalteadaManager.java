 
import java.util.ArrayList;

public class MalteadaManager {
    private ArrayList<Malteada> malteadas = new ArrayList<>();

    public void agregarMalteada(Malteada m) {
        malteadas.add(m);
    }

    public void mostrarMalteadas() {
        System.out.println("\n--- Malteadas disponibles ---");
        for (int i = 0; i < malteadas.size(); i++) {
            Malteada m = malteadas.get(i);
            String tipo = switch (m.getTipo()) {
                case 1 -> "Vaso mediano";
                case 2 -> "Vaso grande";
                default -> "Desconocido";
            };
            System.out.println(
                i + ". Sabores: " + m.getSabores() +
                " | Tipo: " + tipo +
                " | Precio: " + m.getPrecio()
            );
        }
    }

    public Malteada obtenerMalteada(int indice) {
        if (indice >= 0 && indice < malteadas.size()) {
            return malteadas.get(indice);
        }
        return null;
    }
}
