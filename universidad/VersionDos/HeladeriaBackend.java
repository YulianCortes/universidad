package VersionDos; // Paquete donde está nuestro código
import java.util.ArrayList;
import java.util.List;
// Clase que actúa como el "BackEnd" de la heladería.
// Aquí se guardan los pedidos y se gestionan.
public class HeladeriaBackend {
    // Lista para almacenar todos los pedidos realizados
    private List<Helado> pedidos;
    // Constructor: inicializa la lista de pedidos vacía
    public HeladeriaBackend() {
        pedidos = new ArrayList<>();
    }
    // Método para agregar un nuevo pedido a la lista
    public void agregarPedido(Helado helado) {
        pedidos.add(helado); // Añadimos el objeto Helado al ArrayList
    }
    // Método para mostrar todos los pedidos guardados
    public void mostrarPedidos() {
        if (pedidos.isEmpty()) { // Si la lista está vacía
            System.out.println("No hay pedidos aún.");
        } else {
            System.out.println("*** Lista de pedidos ***");
            // Recorremos la lista y mostramos cada pedido
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println((i+1) + ". " + pedidos.get(i));
            }
        }
    }
}
