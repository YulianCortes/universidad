package VersionDos; // Paquete donde está nuestro código
import java.util.ArrayList;
import java.util.List;
// Clase que maneja los pedidos
public class HeladeriaBackend {
    private List<Helado> pedidos;
    public HeladeriaBackend() {
        pedidos = new ArrayList<>();
    }
    // Agregar pedido
    public void agregarPedido(Helado helado) {
        pedidos.add(helado);
    }
    // Mostrar pedidos
    public void mostrarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos aún.");
        } else {
            System.out.println("=== Lista de pedidos ===");
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println((i+1) + ". " + pedidos.get(i));
            }
        }
    }
    // Actualizar un pedido existente
    public void actualizarPedido(int indice, Helado nuevoPedido) {
        if (indice >= 0 && indice < pedidos.size()) {
            pedidos.set(indice, nuevoPedido);
            System.out.println("✅ Pedido actualizado correctamente.");
        } else {
            System.out.println("⚠️ El número de pedido no existe.");
        }
    }
    // Ver cuántos pedidos hay
    public int cantidadPedidos() {
        return pedidos.size();
    }
}