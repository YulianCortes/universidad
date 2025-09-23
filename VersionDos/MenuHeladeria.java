package VersionDos; // Paquete donde está nuestro código
import java.util.Scanner; // Importamos Scanner para leer datos del usuario

public class MenuHeladeria {
    // Scanner global para leer la entrada del usuario
    private static Scanner sc = new Scanner(System.in);

    // Instancia del backend que gestiona la lista de pedidos
    private static HeladeriaBackend backend = new HeladeriaBackend();

    public static void main(String[] args) {
        int opcionPrincipal; // Variable para guardar la opción principal del menú

        // Bucle principal del programa: se repite hasta que el usuario elija salir
        do {
            menuPrincipal(); // Mostramos el menú principal en pantalla
            opcionPrincipal = sc.nextInt(); // Leemos la opción que elige el usuario
            sc.nextLine(); // Limpiamos el buffer (evita problemas al leer cadenas después de números)

            // Evaluamos la opción elegida
            switch (opcionPrincipal) {
                // Si elige cualquier opción de helado (1 a 5)
                case 1: case 2: case 3: case 4: case 5:
                    // Guardamos el tipo de helado según la opción
                    String tipo = obtenerTipo(opcionPrincipal);
                    // Pedimos al usuario el sabor
                    String sabor = elegirSabor();
                    // Pedimos el acompañante
                    String acompanante = elegirAcompanante();
                    // Pedimos el método de pago
                    String pago = elegirPago();

                    // Creamos un nuevo objeto Helado con los datos
                    Helado nuevo = new Helado(tipo, sabor, acompanante, pago);
                    // Lo agregamos a la lista de pedidos en el backend
                    backend.agregarPedido(nuevo);
                    // Confirmamos el pedido en consola
                    System.out.println("✅ Pedido agregado: " + nuevo);
                    break;

                // Si elige la opción 6 (terminar compra)
                case 6:
                    // Mostramos todos los pedidos realizados
                    backend.mostrarPedidos();
                    // Mensaje de despedida
                    System.out.println("👋 Gracias por su compra!");
                    break;

                // Si escribe una opción no válida
                default:
                    System.out.println("⚠️ Opción no válida");
            }
        } while (opcionPrincipal != 6); // El ciclo se repite hasta que se elija "6"
    }

    // Método que imprime el menú principal enmarcado
    public static void menuPrincipal() {
        System.out.println("________________________________");
        System.out.println("|                              |");
        System.out.println("|       POO-PY HELADERIA       |");
        System.out.println("|                              |");
        System.out.println("|  Menú Heladería Poo-Py       |");
        System.out.println("|                              |");
        System.out.println("|  OPCIONES:                   |");
        System.out.println("| 1. Conos                     |");
        System.out.println("| 2. Copas de Helado           |");
        System.out.println("| 3. Ensalada de frutas        |");
        System.out.println("| 4. Malteadas                 |");
        System.out.println("| 5. Litro de Helado           |");
        System.out.println("| 6. TERMINAR                  |");
        System.out.println("|______________________________|");
        System.out.print("Elija una opción: "); // Indicamos que elija una opción
    }

    // Método que convierte la opción numérica en el tipo de helado
    private static String obtenerTipo(int opcion) {
        switch (opcion) {
            case 1: return "Cono";
            case 2: return "Copa";
            case 3: return "Ensalada";
            case 4: return "Malteada";
            case 5: return "Litro";
            default: return "Desconocido"; // Por si acaso
        }
    }

    // Método que muestra el menú de sabores y devuelve el elegido
    private static String elegirSabor() {
        System.out.println("________________________________");
        System.out.println("|                              |");
        System.out.println("|          SABORES             |");
        System.out.println("|                              |");
        System.out.println("| 1. Maracuyá                  |");
        System.out.println("| 2. Vainilla Chips            |");
        System.out.println("| 3. Chocolate                 |");
        System.out.println("| 4. Fresa                     |");
        System.out.println("|______________________________|");
        System.out.print("Elija un sabor: ");

        int opcion = sc.nextInt(); // Leemos el número elegido
        sc.nextLine(); // Limpiamos buffer
        switch (opcion) {
            case 1: return "Maracuyá";
            case 2: return "Vainilla Chips";
            case 3: return "Chocolate";
            case 4: return "Fresa";
            default: return "Sabor desconocido"; // Si elige mal
        }
    }

    // Método que muestra el menú de acompañantes y devuelve el elegido
    private static String elegirAcompanante() {
        System.out.println("________________________________");
        System.out.println("|                              |");
        System.out.println("|        ACOMPAÑANTES          |");
        System.out.println("|                              |");
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
            default: return "Sin acompañante";
        }
    }

    // Método que muestra el menú de métodos de pago y devuelve el elegido
    private static String elegirPago() {
        System.out.println("________________________________");
        System.out.println("|                              |");
        System.out.println("|         MÉTODO DE PAGO       |");
        System.out.println("|                              |");
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