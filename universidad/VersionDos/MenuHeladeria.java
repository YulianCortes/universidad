package VersionDos; // Paquete donde está nuestro código
import java.util.Scanner;
public class MenuHeladeria {
    private static Scanner sc = new Scanner(System.in);
    private static HeladeriaBackend backend = new HeladeriaBackend();
    public static void main(String[] args) {
        int opcionPrincipal;
        do {
            mostrarMenuPrincipal();
            opcionPrincipal = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            switch (opcionPrincipal) {
                case 1: // Crear pedido
                    System.out.print("Ingrese su nombre: ");
                    String cliente = sc.nextLine();
                    String tipo = obtenerTipo(elegirOpcionHelado());
                    String sabor = elegirSabor();
                    String acompanante = elegirAcompanante();
                    String pago = elegirPago();
                    Helado nuevo = new Helado(cliente, tipo, sabor, acompanante, pago);
                    backend.agregarPedido(nuevo);
                    System.out.println("✅ Pedido agregado: " + nuevo);
                    break;
                case 2: // Ver pedidos
                    backend.mostrarPedidos();
                    break;
                case 3: // Actualizar pedido
                    backend.mostrarPedidos();
                    if (backend.cantidadPedidos() > 0) {
                        System.out.print("Ingrese el número del pedido a actualizar: ");
                        int num = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nuevo nombre del cliente: ");
                        String nuevoCliente = sc.nextLine();
                        String nuevoTipo = obtenerTipo(elegirOpcionHelado());
                        String nuevoSabor = elegirSabor();
                        String nuevoAcompanante = elegirAcompanante();
                        String nuevoPago = elegirPago();
                        Helado pedidoActualizado = new Helado(nuevoCliente, nuevoTipo, nuevoSabor, nuevoAcompanante, nuevoPago);
                        backend.actualizarPedido(num - 1, pedidoActualizado);
                    }
                    break;

                case 4: // Salir
                    System.out.println("🍦 Gracias por usar la heladería!😘");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        } while (opcionPrincipal != 4);
    }
    // Menú principal
    public static void mostrarMenuPrincipal() {
        System.out.println("________________________________");
        System.out.println("|       POO-PY HELADERIA       |");
        System.out.println("| 1. Crear nuevo pedido        |");
        System.out.println("| 2. Ver pedidos               |");
        System.out.println("| 3. Actualizar un pedido      |");
        System.out.println("| 4. Salir                     |");
        System.out.println("|______________________________|");
        System.out.print("Elija una opción: ");
    }
    // Elegir tipo de helado
    private static int elegirOpcionHelado() {
        System.out.println("________________________________");
        System.out.println("|          TIPOS DE HELADO     |");
        System.out.println("| 1. Cono                      |");
        System.out.println("| 2. Copa                      |");
        System.out.println("| 3. Ensalada de frutas        |");
        System.out.println("| 4. Malteada                  |");
        System.out.println("| 5. Litro                     |");
        System.out.println("|______________________________|");
        System.out.print("Elija una opción: ");
        return sc.nextInt();
    }
    private static String obtenerTipo(int opcion) {
        switch (opcion) {
            case 1: return "Cono";
            case 2: return "Copa";
            case 3: return "Ensalada de frutas";
            case 4: return "Malteada";
            case 5: return "Litro";
            default: return "Desconocido";
        }
    }
    // Elegir sabor
    private static String elegirSabor() {
        System.out.println("________________________________");
        System.out.println("|            SABORES           |");
        System.out.println("| 1. Maracuyá                  |");
        System.out.println("| 2. Vainilla Chips            |");
        System.out.println("| 3. Chocolate                 |");
        System.out.println("| 4. Fresa                     |");
        System.out.println("|______________________________|");
        System.out.print("Elija un sabor: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1: return "Maracuyá";
            case 2: return "Vainilla Chips";
            case 3: return "Chocolate";
            case 4: return "Fresa";
            default: return "Desconocido";
        }
    }
    // Elegir acompañante
    private static String elegirAcompanante() {
        System.out.println("________________________________");
        System.out.println("|        ACOMPAÑANTES          |");
        System.out.println("| 1. Galleta                   |");
        System.out.println("| 2. Gomita                    |");
        System.out.println("| 3. Chips                     |");
        System.out.println("|______________________________|");
        System.out.print("Elija un acompañante: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1: return "Galleta";
            case 2: return "Gomita";
            case 3: return "Chips";
            default: return "Ninguno";
        }
    }
    // Elegir pago
    private static String elegirPago() {
        System.out.println("________________________________");
        System.out.println("|         MÉTODO DE PAGO       |");
        System.out.println("| 1. Efectivo                  |");
        System.out.println("| 2. Pago virtual              |");
        System.out.println("|______________________________|");
        System.out.print("Elija un método de pago: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1: return "Efectivo";
            case 2: return "Virtual";
            default: return "No especificado";
        }
    }
}