package HELADERIA;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Helpers {
 
    public static ArrayList<Heladeria> crudHeladeria(ArrayList<Heladeria> listaHeladerias){
        int opcion = 0;
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
 
        Menus menuCrud = new Menus(40, '-', '1');
        ArrayList<String> options = new ArrayList<String>();
        options.add("Crear");
        options.add("Ver");
        options.add("Editar");
        options.add("Eliminar");
        options.add("Volver");
        System.out.println("CRUD Heladeria");
        opcion = menuCrud.createMenu(options, false);
        switch (opcion) {
            case '1':
                System.out.println("Crear Heladeria");
                System.out.println("Escriba el ID de la Heladeria: ");
                int id = input.nextInt();
                System.out.println("Escriba la direccion de la Heladeria: ");
                String direccion = input.next();
                Heladeria nuevaHeladeria = new Heladeria(id, direccion);
                listaHeladerias.add(nuevaHeladeria);
                break;
            case '2':
                System.out.println("Ver Heladeria");
                System.out.println("Escriba el ID de la Heladeria: ");
                id = input.nextInt();       // lee el ID que se va a buscar en el arraylist
                boolean encontrado = false;
                for(Heladeria heladeria : listaHeladerias){
                    if(heladeria.id == id){
                        System.out.println("ID: " + heladeria.id);
                        System.out.println("Direccion: " + heladeria.getDireccion());
                        System.out.println("Helados disponibles: " + heladeria.getListaHeladosDisponibles());
                        System.out.println("Malteadas disponibles: " + heladeria.getListaMalteadasDisponibles());
                        System.out.println("Toppings: " + heladeria.getListaToppings());
                        System.out.println("Pedidos: " + heladeria.getListaPedidos());
                        encontrado = true;
                    }
                }
                if(encontrado == false){
                    System.out.println("No se encontro la heladeria");
                }
                break;

            case '3': //  NUEVO: Editar Heladeria
                editarHeladeria(listaHeladerias);
                break;

            default:
                break;
        }
 
        return listaHeladerias;
    }
 
    // 🔹 NUEVO MÉTODO: Editar Heladeria
    public static void editarHeladeria(ArrayList<Heladeria> listaHeladerias) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("Editar Heladeria");
        System.out.print("Escribe el ID de la heladería que quieres editar: ");
        int id = input.nextInt();
        input.nextLine(); // limpiar buffer

        Heladeria heladeriaAEditar = null;
        for (Heladeria h : listaHeladerias) {
            if (h.id == id) {
                heladeriaAEditar = h;
                break;
            }
        }

        if (heladeriaAEditar == null) {
            System.out.println("⚠ Heladería no encontrada.");
            return;
        }

        int opcion;
        do {
            System.out.println("\n--- EDITAR HELADERÍA ---");
            System.out.println("1. Cambiar dirección");
            System.out.println("2. Editar helados disponibles");
            System.out.println("3. Editar malteadas disponibles");
            System.out.println("4. Editar toppings disponibles");
            System.out.println("5. Editar pedidos existentes");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nueva dirección: ");
                    String nuevaDireccion = input.nextLine();
                    heladeriaAEditar.setDireccion(nuevaDireccion);
                    System.out.println("✅ Dirección actualizada.");
                    break;

                case 2:
                    System.out.println("Helados disponibles: " + heladeriaAEditar.getListaHeladosDisponibles());
                    System.out.println("⚠ Aquí podrías editar helados...");
                    break;

                case 3:
                    System.out.println("Malteadas disponibles: " + heladeriaAEditar.getListaMalteadasDisponibles());
                    System.out.println("⚠ Aquí podrías editar malteadas...");
                    break;

                case 4:
                    System.out.println("Toppings disponibles: " + heladeriaAEditar.getListaToppings());
                    System.out.println("⚠ Aquí podrías editar toppings...");
                    break;

                case 5:
                    if (heladeriaAEditar.getListaPedidos().isEmpty()) {
                        System.out.println("No hay pedidos en esta heladería.");
                    } else {
                        System.out.println("Pedidos existentes:");
                        int i = 1;
                        for (Pedido p : heladeriaAEditar.getListaPedidos()) {
                            System.out.println(i + ". Mesa: " + p.mesa + ", Propina: " + p.propina);
                            i++;
                        }
                        System.out.print("¿Cuál pedido quieres editar? (0 para cancelar): ");
                        int pedidoIndex = input.nextInt() - 1;
                        input.nextLine();
                        if (pedidoIndex >= 0 && pedidoIndex < heladeriaAEditar.getListaPedidos().size()) {
                            Pedido pedido = heladeriaAEditar.getListaPedidos().get(pedidoIndex);
                            pedido.editarPedido(); // 🔹 usa el método de Pedido
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saliendo de edición...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }
}
