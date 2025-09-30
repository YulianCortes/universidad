import java.util.ArrayList;

public class PedidoManager {
    private ArrayList<Pedido> pedidos;

    public PedidoManager() {
        pedidos = new ArrayList<>();
        // Crear 30 mesas fijas
        for (int i = 1; i <= 30; i++) {
            pedidos.add(new Pedido(i));
        }
    }

    // Obtener pedido por número de mesa
    public Pedido getPedidoPorMesa(int mesa) {
        if (mesa >= 1 && mesa <= pedidos.size()) {
            return pedidos.get(mesa - 1);
        }
        return null;
    }

    // Mostrar estado de todas las mesas
    public void mostrarPedidos() {
        System.out.println("\n--- Estado de las mesas ---");
        for (Pedido pedido : pedidos) {
            if (pedido.estaLibre()) {
                System.out.println("Mesa " + pedido.getMesa() + ": Libre");
            } else {
                System.out.println("Mesa " + pedido.getMesa() + ": Ocupada, total = $" + pedido.calcularCuenta());
                for (Helado h : pedido.getListaHelados()) {
                    String tipo = switch (h.getTipo()) {
                        case 1 -> "Cono";
                        case 2 -> "Canasta";
                        case 3 -> "Vaso";
                        default -> "Desconocido";
                    };
                    System.out.println("  Helado: " + h.getSabores() + " | Tipo: " + tipo + " | Toppings: " + h.getToppings() + " | Precio: " + h.calcularPrecio());
                }
                for (Malteada m : pedido.getListaMalteadas()) {
                    String tipo = switch (m.getTipo()) {
                        case 1 -> "Vaso mediano";
                        case 2 -> "Vaso grande";
                        default -> "Desconocido";
                    };
                    System.out.println("  Malteada: " + m.getSabores() + " | Tipo: " + tipo + " | Toppings: " + m.getToppings() + " | Precio: " + m.calcularPrecio());
                }
            }
        }
    }

    // Cerrar cuenta de una mesa
    public void cerrarCuenta(int mesa) {
        Pedido pedido = getPedidoPorMesa(mesa);
        if (pedido == null) {
            System.out.println("⚠️ La mesa " + mesa + " no existe.");
            return;
        }
        if (pedido.estaLibre()) {
            System.out.println("⚠️ La mesa " + mesa + " ya está libre.");
            return;
        }

        System.out.println("\n💰 Cuenta de la mesa " + mesa + ": $" + pedido.calcularCuenta());
        pedido.limpiarPedido();
        System.out.println("✅ La mesa " + mesa + " ahora está libre.");
    }

    // Obtener lista de mesas libres
    public ArrayList<Integer> getMesasLibres() {
        ArrayList<Integer> libres = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.estaLibre()) {
                libres.add(pedido.getMesa());
            }
        }
        return libres;
    }
}
